// https://leetcode.com/problems/extra-characters-in-a-string/description/
// using recursion
// t.c.=O(n^2 * 2^n + m*k), s.c.=O(n + m*k), n=len(s), m=no. of words, k=avg. word len
class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> words=new HashSet<>();
        for(String word:dictionary)
            words.add(word);
        return dfs(0, s, words);
    }
    private int dfs(int index, String s, Set<String> words) {
        if(index==s.length())
            return 0;
        int res=1+dfs(index+1, s, words);
        for(int i=index;i<s.length();i++)
            if(words.contains(s.substring(index, i+1)))
                res=Math.min(res, dfs(i+1, s, words));
        return res;
    }
}

// using dp top-down approach
// t.c.=O(n^3 + m*k), s.c.=O(n+m*k)
class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int len=s.length();
        Set<String> words=new HashSet<>();
        int[] dp=new int[len+1];
        for(String word:dictionary)
            words.add(word);
        Arrays.fill(dp, -1);
        dp[len]=0;
        return dfs(0, s, dp, words);
    }
    private int dfs(int index, String s, int[] dp, Set<String> words) {
        if(dp[index]!=-1)
            return dp[index];
        int res=1+dfs(index+1, s, dp, words);
        for(int i=index;i<s.length();i++)
            if(words.contains(s.substring(index, i+1)))
                res=Math.min(res, dfs(i+1, s, dp, words));
        dp[index]=res;
        return res;
    }
}

// using Trie
// t.c.=O(n^2 + m*k), s.c.=O(n + m*k)
class TrieNode {
    TrieNode[] children;
    boolean isWord;
    public TrieNode() {
        children=new TrieNode[26];
        isWord=false;
    }
}
class Trie {
    TrieNode root;
    Trie() {
        root=new TrieNode();
    }
    public void insert(String word) {
        TrieNode node=root;
        for(char ch:word.toCharArray()) {
            if(node.children[ch-'a']==null)
                node.children[ch-'a']=new TrieNode();
            node=node.children[ch-'a'];
        }
        node.isWord=true;
    }
}
class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int len=s.length();
        int[] dp=new int[len+1];
        Trie trie=new Trie();
        Arrays.fill(dp, -1);
        dp[len]=0;
        for(String word:dictionary)
            trie.insert(word);
        return dfs(0, s, trie, dp);
    }
    private int dfs(int index, String s, Trie trie, int[] dp) {
        if(dp[index]!=-1)
            return dp[index];
        TrieNode node=trie.root;
        int res=1+dfs(index+1, s, trie, dp);
        for(int i=index;i<s.length();i++) {
            if(node.children[s.charAt(i)-'a']==null)    break;
            node=node.children[s.charAt(i)-'a'];
            if(node.isWord)
                res=Math.min(res, dfs(i+1, s, trie, dp));
        }
        dp[index]=res;
        return res;
    }
}
