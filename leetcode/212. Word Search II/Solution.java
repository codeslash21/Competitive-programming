// https://leetcode.com/problems/word-search-ii/
// using brute force approach using dfs
// t.c.=O(W*m*n*4^L), s.c.=O(L), L=max length of word, W=total number of words
class Solution {
    private int m, n;
    private char[][] board;
    private int[][] dirs=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public List<String> findWords(char[][] board, String[] words) {
        this.board=board;
        this.m=board.length;
        this.n=board[0].length;
        List<String> res=new ArrayList<>();
        for(String word:words)
            if(exists(word))
                res.add(word);
        return res;
    }
    private boolean exists(String word) {
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(dfs(i, j, word, 0)) return true;
        return false;
    }
    private boolean dfs(int r, int c, String word, int index) {
        if(index==word.length())    return true;
        if(r<0 || r>=m || c<0 || c>=n)  return false;
        if(board[r][c]!=word.charAt(index)) return false;
        char temp=board[r][c];
        board[r][c]='#';    // marked the cell as visited;
        boolean found=false;
        for(int[] dir:dirs)
            found=found || dfs(r+dir[0], c+dir[1], word, index+1);
        board[r][c]=temp;   // backtrack
        return found;
    }
}
