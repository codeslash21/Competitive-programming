// https://leetcode.com/problems/island-perimeter/description/
// using dfs
// t.c.=O(m*n), s.c.=O(m*n)
class Solution {
    boolean[][] visited;
    int[][] grid;
    int row, col;
    public int islandPerimeter(int[][] grid) {
        this.grid=grid;
        this.row=grid.length;
        this.col=grid[0].length;
        visited=new boolean[row][col];
        for(int r=0;r<row;r++)
            for(int c=0;c<col;c++)
                if(grid[r][c]==1)
                    return dfs(r, c);
        return 0;
    }
    private int dfs(int r, int c) {
        if(r<0 || r>=row || c<0 || c>=col || grid[r][c]==0)
            return 1;
        if(visited[r][c])   return 0;
        visited[r][c]=true;
        return dfs(r+1, c)+dfs(r-1, c)+dfs(r, c+1)+dfs(r, c-1);
    }
}

// using iteration
// t.c.=O(m*n), s.c.=O(1)
class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows=grid.length, cols=grid[0].length, res=0;
        for(int r=0;r<rows;r++) 
            for(int c=0;c<cols;c++) 
                if(grid[r][c]==1) {
                    res+=4;
                    if(r>0 && grid[r-1][c]==1)
                        res-=2;
                    if(c>0 && grid[r][c-1]==1)
                        res-=2;
                }
        return res;
    }
}
