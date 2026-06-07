// https://leetcode.com/problems/design-add-and-search-words-data-structure/description/
// t.c.=O(L), O(26*K*L) for pattern, s.c.=O(N*L), L=avg. word length, K=number of dots, N=total number of words inserted
class WordDictionary {
    private WordDictionary[] children;
    private boolean isEnd;
    public WordDictionary() {
        children=new WordDictionary[26];
        isEnd=false;
    }
    
    public void addWord(String word) {
        WordDictionary current=this;
        for(char ch:word.toCharArray()) {
            if(current.children[ch-'a']==null)
                current.children[ch-'a']=new WordDictionary();
            current=current.children[ch-'a'];
        }
        current.isEnd=true;
    }
    
    public boolean search(String word) {
        return dfs(this, word, 0);
    }
    private boolean dfs(WordDictionary node, String word, int index) {
        if(index==word.length())
            return node.isEnd;
        char ch=word.charAt(index);
        if(ch=='.') {
            for(WordDictionary child:node.children)
                if(child!=null && dfs(child, word, index+1))
                    return true;
            return false;
        } else {
            WordDictionary child=node.children[ch-'a'];
            return child!=null && dfs(child, word, index+1);
        }
    }
}
