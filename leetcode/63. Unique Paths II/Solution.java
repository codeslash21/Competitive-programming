// using dp iterative approach
// t.c.=O(m*n), s.c.=O(1)
class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        if(grid[0][0]==1)
            return 0;
        grid[0][0]=1;
        for(int i=1;i<m;i++)
            grid[i][0]=grid[i][0]!=1 && grid[i-1][0]==1?1:0;
        for(int i=1;i<n;i++)
            grid[0][i]=grid[0][i]!=1 && grid[0][i-1]==1?1:0;
        for(int row=1;row<m;row++)
            for(int col=1;col<n;col++) 
                if(grid[row][col]==1)
                    grid[row][col]=0;
                else 
                    grid[row][col]=grid[row-1][col]+grid[row][col-1];
        return grid[m-1][n-1];
    }
}
