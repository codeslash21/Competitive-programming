// https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/
// using recursion
// t.c.=O(m*n*4^(m*n)), s.c.=O(m*n)
class Solution {
    int[][] dirs=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        int rows=matrix.length, cols=matrix[0].length, res=0;
        for(int r=0;r<rows;r++)
            for(int c=0;c<cols;c++)
                res=Math.max(res, dfs(matrix, r, c, rows, cols));
        return res;
    }
    private int dfs(int[][] grid, int row, int col, int rows, int cols) {
        if(row<0 || row>=rows || col<0 || col>=cols)    return 0;
        int res=0;
        for(int[] dir:dirs) {
            int newRow=row+dir[0], newCol=col+dir[1];
            if(newRow<0 || newRow>=rows || newCol<0 || newCol>=cols)    continue;
            if(grid[newRow][newCol]<=grid[row][col])    continue;
            res=Math.max(res, dfs(grid, newRow, newCol, rows, cols));
        }
        return res+1;
    }
}

// using topological sort
// t.c.=O(m*n), s.c.=O(m*n)
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int rows=matrix.length, cols=matrix[0].length, res=0;
        int[][] dirs=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int[][] indegree=new int[rows][cols];
        Queue<int[]> queue=new LinkedList<>();
        for(int r=0;r<rows;r++)
            for(int c=0;c<cols;c++)
                for(int[] dir:dirs) {
                    int newR=r+dir[0], newC=c+dir[1];
                    if(newR>=0 && newR<rows && newC>=0 && newC<cols && matrix[newR][newC]<matrix[r][c])
                        indegree[r][c]++;
                }
        for(int r=0;r<rows;r++)
            for(int c=0;c<cols;c++)
                if(indegree[r][c]==0)   queue.offer(new int[]{r, c});
        while(!queue.isEmpty()) {
            res++;
            int levelSize=queue.size();
            while(levelSize-->0) {
                int[] cell=queue.poll();
                int r=cell[0], c=cell[1];
                for(int[] dir:dirs) {
                    int newR=r+dir[0], newC=c+dir[1];
                    if(newR>=0 && newR<rows && newC>=0 && newC<cols && 
                            matrix[newR][newC]>matrix[r][c]) {
                        indegree[newR][newC]--;
                        if(indegree[newR][newC]==0)
                            queue.offer(new int[]{newR, newC});
                    }
                }
            }
        }
        return res;
    }
}
