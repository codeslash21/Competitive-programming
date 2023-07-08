// using backtracking
// t.c.=O(n!), s.c.=O(n)
class Solution {
    int res=0, size;
    public int totalNQueens(int n) {
        size=n;
        backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return res;
    }
    public void backtrack(int row, Set<Integer> cols, Set<Integer> diagonals, Set<Integer> antiDiagonals) {
        if(row==size) {
            res++;
            return;
        }
        for(int col=0;col<size;col++) {
            int currDiagonal=row-col;
            int currAntiDiagonal=row+col;
            if(cols.contains(col) || diagonals.contains(currDiagonal) || antiDiagonals.contains(currAntiDiagonal))
                continue;
            cols.add(col);
            diagonals.add(currDiagonal);
            antiDiagonals.add(currAntiDiagonal);
            backtrack(row+1, cols, diagonals, antiDiagonals);
            cols.remove(col);
            diagonals.remove(currDiagonal);
            antiDiagonals.remove(currAntiDiagonal);
        }
    }
}
