// https://leetcode.com/problems/implement-trie-prefix-tree/description/
// using array
class Trie {
    Set<String> words;
    public Trie() {
        words=new HashSet<>();
    }
    
    public void insert(String word) {
        words.add(word);
    }
    
    public boolean search(String word) {
        return words.contains(word);
    }
    
    public boolean startsWith(String prefix) {
        for(String word:words)
            if(word.startsWith(prefix))
                return true;
        return false;
    }
}

// using Trie
// t.c.=O(L), s.c.=O(N*26), where L=length of the word or prefix, N=total number of characters across all the inserted words
class Trie {
    private Trie[] children;
    private boolean isEnd;
    public Trie() {
        children=new Trie[26];
        isEnd=false;
    }
    
    public void insert(String word) {
        Trie node=this;
        for(char ch:word.toCharArray()) {
            int index=ch-'a';
            if(node.children[index]==null)
                node.children[index]=new Trie();
            node=node.children[index];
        }
        node.isEnd=true;
    }
    
    public boolean search(String word) {
        Trie node=traverseTrie(word);
        return node!=null && node.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        return traverseTrie(prefix)!=null;
    }
    private Trie traverseTrie(String str) {
        Trie node=this;
        for(char ch:str.toCharArray()) {
            int index=ch-'a';
            if(node.children[index]==null)
                return null;
            node=node.children[index];
        }
        return node;
    }
}

