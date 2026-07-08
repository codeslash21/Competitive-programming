// https://leetcode.com/problems/cherry-pickup/description/
// using recursion
// t.c.=O(16^n), s.c.=O(n)
class Solution {
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        return Math.max(0, dfs(0, 0, 0, 0, grid, n));
    }
    private int dfs(int r1, int c1, int r2, int c2, int[][] grid, int n) {
        if(r1>=n || c1>=n || r2>=n || c2>=n || grid[r1][c1]==-1 || grid[r2][c2]==-1)
            return -1000;
        if(r1==n-1 && c1==n-1 && r2==n-1 && c2==n-1)
            return grid[r1][c1];
        int res=dfs(r1+1, c1, r2+1, c2, grid, n);
        res=Math.max(res, dfs(r1, c1+1, r2, c2+1, grid, n));
        res=Math.max(res, dfs(r1+1, c1, r2, c2+1, grid, n));
        res=Math.max(res, dfs(r1, c1+1, r2+1, c2, grid, n));
        res+=grid[r1][c1]+grid[r2][c2];
        if(r1==r2 && c1==c2)
            res-=grid[r1][c1];
        return res;
    }
}

// using dp
// t.c.=O(n^3), s.c.=O(n^3)
class Solution {
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        int[][][] dp=new int[n][n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                Arrays.fill(dp[i][j], -1000);
        for(int r1=n-1;r1>=0;r1--)
            for(int c1=n-1;c1>=0;c1--)
                for(int r2=n-1;r2>=0;r2--) {
                    int c2=r1+c1-r2;
                    // base cases
                    if(c2<0 || c2>=n)   continue;
                    if(grid[r1][c1]==-1 || grid[r2][c2]==-1)    continue;
                    if(r1==n-1 && c1==n-1)
                        dp[r1][c1][r2]=grid[r1][c1];
                    else {
                        int res=-1000;
                        if(r1+1<n && r2+1<n)
                            res=Math.max(res, dp[r1+1][c1][r2+1]);
                        if(c1+1<n)
                            res=Math.max(res, dp[r1][c1+1][r2]);
                        if(c1+1<n && r2+1<n)
                            res=Math.max(res, dp[r1][c1+1][r2+1]);
                        if(r1+1<n)
                            res=Math.max(res, dp[r1+1][c1][r2]);
                        if(res==-1000)  continue;
                        res+=grid[r1][c1];
                        if(r1!=r2 || c1!=c2)
                            res+=grid[r2][c2];
                        dp[r1][c1][r2]=res;
                    }
                }
        return Math.max(0,dp[0][0][0]);
    }
}
