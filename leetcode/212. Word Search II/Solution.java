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

// using trie
// t.c.=O(m*n*4*3^(t-1)+s), s.c.=O(s), m=no. of rows, n=no. of cols, t=max len of any word, s=sum of length of all words
class TrieNode {
    TrieNode[] children;
    int refs, idx;
    TrieNode() {
        children=new TrieNode[26];
        refs=0;
        idx=-1;
    }
}
class Trie {
    TrieNode root;
    Trie() {
        root=new TrieNode();
    }
    public void insert(String word, int index) {
        TrieNode node=root;
        node.refs++;
        for(char ch:word.toCharArray()) {
            if(node.children[ch-'a']==null)
                node.children[ch-'a']=new TrieNode();
            node=node.children[ch-'a'];
            node.refs++;
        }
        node.idx=index;
    }
}
class Solution {
    List<String> res=new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        int m=board.length, n=board[0].length, len=words.length;
        Trie trie=new Trie();
        for(int i=0;i<len;i++)
            trie.insert(words[i], i);
        for(int r=0;r<m;r++)
            for(int c=0;c<n;c++)
                dfs(r, c, board, trie.root, words);
        return res;
    }
    private void dfs(int r, int c, char[][] board, TrieNode node, String[] words) {
        if(r<0 || r>=board.length || c<0 || c>=board[0].length || board[r][c]=='*' ||
            node.children[board[r][c]-'a']==null)
                return;
        char temp=board[r][c];
        board[r][c]='*';
        TrieNode prev=node;
        node=node.children[temp-'a'];
        if(node.idx!=-1) {  // we have found a match
            res.add(words[node.idx]);
            node.idx=-1;
            node.refs--;
            if(node.refs==0) {
                prev.children[temp-'a']=null;
                board[r][c]=temp;
                return;
            }
        }
        dfs(r+1, c, board, node, words);
        dfs(r, c+1, board, node, words);
        dfs(r-1, c, board, node, words);
        dfs(r, c-1, board, node, words);
        board[r][c]=temp;
    }
}
