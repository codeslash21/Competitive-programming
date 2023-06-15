// using dp iterative approach
// t.c.=O(m*n), s.c.=O(1)
class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        for(int i=1;i<m;i++)
            grid[i][0]+=grid[i-1][0];
        for(int i=1;i<n;i++)
            grid[0][i]+=grid[0][i-1];
        for(int col=1; col<n; col++) 
            for(int row=1; row<m; row++)
                grid[row][col]+=Math.min(grid[row][col-1], grid[row-1][col]);
        return grid[m-1][n-1];
    }
}
