// Using dfs
// t.c.=O(m*n), s.c.=O(m*n)
class Solution {
    int cnt=0, row, col;
    int[][] directions = {{0,1},  {0,-1}, {1,0}, {-1,0}};
    public int maxAreaOfIsland(int[][] grid) {
        this.row=grid.length; 
        this.col=grid[0].length;
        int res=0;
        for(int i=0;i<row;i++) 
            for(int j=0;j<col;j++) {
                if(grid[i][j]==1) {
                    cnt=0;
                    dfs(grid, i, j);
                    res=Math.max(res, cnt);
                }
            }
        return res;
    }
    private void dfs(int[][] grid, int r, int c) {
        grid[r][c]=0;
        cnt++;
        for(int[] d:directions) {
            int newR=r+d[0], newC=c+d[1];
            if(newR>=0 && newR<row && newC>=0 && newC<col)
                if(grid[newR][newC]==1) 
                    dfs(grid, newR, newC);
        }
    }
}
