// https://leetcode.com/problems/pacific-atlantic-water-flow/description/
// using dfs
// t.c.=O(m*n), s.c.=O(m*n)
class Solution {
    private int rows, cols;
    private int[][] directions=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.rows=heights.length;
        this.cols=heights[0].length;
        boolean[][] pacific=new boolean[rows][cols], atlantic=new boolean[rows][cols];
        List<List<Integer>> result=new ArrayList<>();
        // check for pacific ocean
        for(int col=0;col<cols;col++)  dfs(heights, 0, col, pacific);
        for(int row=0;row<rows;row++)   dfs(heights, row, 0, pacific);
        // check for atlantic ocean
        for(int row=0;row<rows;row++)   dfs(heights, row, cols-1, atlantic);
        for(int col=0;col<cols;col++)   dfs(heights, rows-1, col, atlantic);
        for(int row=0;row<rows;row++)
            for(int col=0;col<cols;col++)
                if(pacific[row][col] && atlantic[row][col])
                    result.add(List.of(row, col));
        return result;
    }
    private void dfs(int[][] heights, int row, int col, boolean[][] reachable) {
        reachable[row][col]=true;
        for(int[] dir:directions) {
            int newRow=row+dir[0], newCol=col+dir[1];
            if(newRow>=0 && newRow<rows && newCol>=0 && newCol<cols && 
                !reachable[newRow][newCol] && heights[newRow][newCol]>=heights[row][col])
                    dfs(heights, newRow, newCol, reachable);
        }
    }
}
