// using bfs
// t.c.=O(m*n), s.c.=O(m*n)
class State {
    int row, col, steps;
    State(int row, int col, int steps) {
        this.row=row;
        this.col=col;
        this.steps=steps;
    }
}
class Solution {
    int m, n;
    public boolean isValid(int row, int col) {
        return row>=0 && row<m && col>=0 && col<n;
    }
    public int[][] updateMatrix(int[][] mat) {
        m=mat.length;
        n=mat[0].length;
        boolean[][] seen = new boolean[m][n];
        int[][] matrix = new int[m][n];
        int[][] directions = new int[][] {{0,1}, {0,-1}, {1, 0}, {-1, 0}};
        Queue<State> queue = new LinkedList<>();
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++) {
                matrix[i][j]=mat[i][j];
                if(mat[i][j]==0) {
                    queue.offer(new State(i, j, 0));
                    seen[i][j]=true;
                }
            }
        while(!queue.isEmpty()) {
            State currState = queue.poll();
            int row=currState.row, col=currState.col, steps=currState.steps;
            for(int[] d:directions) {
                int newRow=row+d[0], newCol=col+d[1];
                if(isValid(newRow, newCol) && !seen[newRow][newCol]) {
                    matrix[newRow][newCol]=steps+1;
                    queue.offer(new State(newRow, newCol, steps+1));
                    seen[newRow][newCol]=true;
                }
            }
        }
        return matrix;
    }
}
