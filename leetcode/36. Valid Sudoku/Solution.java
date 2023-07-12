// using hashset
// t.c.=O(n^2), s.c.=O(n^2)
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n=board.length;
        Set<Character>[] row = new HashSet[n];
        Set<Character>[] col = new HashSet[n];
        Set<Character>[] box = new HashSet[n];
        for(int i=0;i<n;i++) {
            row[i]=new HashSet<Character>();
            col[i]=new HashSet<Character>();
            box[i]=new HashSet<Character>();
        }
        for(int r=0;r<n;r++)
            for(int c=0;c<n;c++) {
                if(board[r][c]=='.')
                    continue;
                char val=board[r][c];
                if(row[r].contains(val))
                    return false;
                row[r].add(val);
                if(col[c].contains(val))
                    return false;
                col[c].add(val);
                int boxNum=(r/(int)Math.pow(n,0.5))*(int)Math.pow(n,0.5)+(c/(int)Math.pow(n,0.5));
                if(box[boxNum].contains(val))
                    return false;
                box[boxNum].add(val);
            }
        return true;
    }
}

// using bit masking
// t.c.=O(n^2), s.c.=O(n)
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n=board.length;
        int[] row = new int[n], col=new int[n], box=new int[n];
        for(int r=0;r<n;r++)
            for(int c=0;c<n;c++) {
                if(board[r][c]=='.')
                    continue;
                int val=board[r][c]-'0';
                int pos=1<<val;
                if((row[r]&pos)>0)
                    return false;
                row[r] |= pos;
                if((col[c]&pos)>0)
                    return false;
                col[c] |= pos;
                int boxNum=(r/3)*3+(c/3);
                if((box[boxNum]&pos)>0)
                    return false;
                box[boxNum] |= pos;
            }
        return true;
    }
}
