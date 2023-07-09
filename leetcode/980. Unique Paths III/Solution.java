// using backtracking
// t.c.=O(3^n), s.c.=O(n), where n=total number of cells in the grid
class Solution {
    int res=0, row, col;
    int unblocked=0, visited=0;
    int[][] directions = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
    public int uniquePathsIII(int[][] grid) {
        int startRow=0, startCol=0;
        row=grid.length;
        col=grid[0].length;
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++){
                if(grid[i][j]>=0)
                    unblocked++;
                if(grid[i][j]==1) {
                    startRow=i;
                    startCol=j;
                }
            }
        backtrack(startRow, startCol, grid);
        return res;
    }
    public void backtrack(int r, int c, int[][] grid) {
        if(grid[r][c]==2) {
            if(visited==unblocked-1)
                res++;
            return;
        }
        int temp=grid[r][c];
        grid[r][c]=-4;
        visited++;
        for(int[] d:directions) {
            int nextR=r+d[0], nextC=c+d[1];
            if(nextR<0 || nextR>=row || nextC<0 || nextC>=col || grid[nextR][nextC]<0)
                continue;
            backtrack(nextR, nextC, grid);
        }
        grid[r][c]=temp;
        visited--;
    }
}
