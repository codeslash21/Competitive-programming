// using backtracking
// t.c.=O(n*3^l), s.c.=O(l), where n=number of cells in the board, and l=length of the given word
class Solution {
    int row, col;
    int[][] direction = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public boolean exist(char[][] board, String word) {
        row=board.length;
        col=board[0].length;
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++)
                if(backtrack(board, i, j, word, 0))
                    return true;
        return false;
    }
    public boolean backtrack(char[][] board, int r, int c, String word, int index) {
        if(index>=word.length())
            return true;
        if(r<0 || r>=row || c<0 || c>=col || board[r][c]!=word.charAt(index))
            return false;
        boolean res=false;
        board[r][c]='#';
        for(int[] d:direction) {
            res=backtrack(board, r+d[0], c+d[1], word, index+1);
            if(res)
                break;
        }
        board[r][c]=word.charAt(index);
        return res;
    }
}
