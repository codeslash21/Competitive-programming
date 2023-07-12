// using backtracking
// t.c.=O((n!)^n), s.c.=O(n)
class Solution {
    int n, boxSize;
    int[] row, col, box;
    char[][] board;
    boolean solved=false;
    public void solveSudoku(char[][] board) {
        n=board.length;
        boxSize=(int)Math.pow(n,0.5);
        this.board = board;
        row=new int[n];
        col=new int[n];
        box=new int[n];
        for(int r=0;r<n;r++)
            for(int c=0;c<n;c++)
                if(board[r][c]!='.')
                    placeVal(r, c, board[r][c]-'0');
        backtrack(0, 0);
    }
    private void backtrack(int r, int c) {
        if(board[r][c]=='.') {
            for(int d=1;d<=n;d++) {
                if(couldPlace(r, c, d)) {
                    placeVal(r, c, d);
                    placeNext(r, c);
                    if(solved)
                        return;
                    removeVal(r, c, d);
                }
            }
        }
        else
            placeNext(r, c);
    }
    private void removeVal(int r, int c, int val) {
        int pos=1<<val;
        int idx=(r/boxSize)*boxSize+(c/boxSize);
        row[r]^=pos;
        col[c]^=pos;
        box[idx]^=pos;
        board[r][c]='.';
    }
    private void placeNext(int r, int c) {
        if(r==n-1 && c==n-1)
            solved=true;
        else if(c==n-1)
            backtrack(r+1, 0);
        else
            backtrack(r, c+1);
    }
    private boolean couldPlace(int r, int c, int val) {
        int pos=1<<val;
        int idx=(r/boxSize)*boxSize+(c/boxSize);
        return (row[r]&pos)+(col[c]&pos)+(box[idx]&pos)==0;
    }
    void placeVal(int r, int c, int val) {
        int pos=1<<val;
        int idx=(r/boxSize)*boxSize + (c/boxSize);
        row[r]|=pos;
        col[c]|=pos;
        box[idx]|=pos;
        board[r][c]=(char)(val+'0');
    }
}
