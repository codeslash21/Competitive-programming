// usinng backtracking
// t.c.=O(n!), s.c.=O(n^2)
class Solution {
    int size;
    List<List<String>> solutions = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        size=n;
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                board[i][j]='.';
        backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>(), board);
        return solutions;
    }
    public List<String> createState(char[][] state) {
        List<String> board = new ArrayList<>();
        for(int row=0;row<size;row++) {
            String currRow = new String(state[row]);
            board.add(currRow);
        }
        return board;
    }
    public void backtrack(int row, Set<Integer> cols, Set<Integer> diagonals, Set<Integer> antiDiagonals, char[][] state) {
        if(row==size) {
            solutions.add(createState(state));
            return;
        }
        for(int col=0;col<size;col++) {
            int currDiagonal=row-col;
            int currAntiDiagonal=row+col;
            if(cols.contains(col)||diagonals.contains(currDiagonal)||antiDiagonals.contains(currAntiDiagonal))
                continue;
            cols.add(col);
            diagonals.add(currDiagonal);
            antiDiagonals.add(currAntiDiagonal);
            state[row][col]='Q';
            backtrack(row+1, cols, diagonals, antiDiagonals, state);
            cols.remove(col);
            diagonals.remove(currDiagonal);
            antiDiagonals.remove(currAntiDiagonal);
            state[row][col]='.';
        }
    }
}
