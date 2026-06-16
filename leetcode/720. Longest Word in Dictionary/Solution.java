// https://leetcode.com/problems/longest-word-in-dictionary/description/
// using set and sorting
// t.c.=O(n*L*logn), s.c.=O(n*L)
class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words, (a,b)-> a.length()==b.length()? a.compareTo(b):a.length()-b.length());
        Set<String> buildable=new HashSet<>();
        String result="";
        buildable.add("");
        for(String word:words) 
            if(buildable.contains(word.substring(0, word.length()-1))) {
                buildable.add(word);
                if(word.length()>result.length())
                    result=word;
            }
        return result;
    }
}

// using Trie
// t.c.=O(nL), s.c.=O(nL+L), n=total words, L=max word length
class Trie {
    Trie[] children;
    boolean isEnd;
    public Trie() {
        children=new Trie[26];
        isEnd=false;
    }
    public void insert(String word) {
        Trie node=this;
        for(char ch:word.toCharArray()) {
            if(node.children[ch-'a']==null)
                node.children[ch-'a']=new Trie();
            node=node.children[ch-'a'];
        }
        node.isEnd=true;
    }
    public String findLongestWord(Trie node, String ans, StringBuilder sb) {
        if(sb.length()>ans.length())
            ans=sb.toString();
        for(int idx=0;idx<26;idx++) {
            Trie child=node.children[idx];
            if(child!=null && child.isEnd) {
                sb.append((char)(idx+'a'));
                ans=findLongestWord(child, ans, sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
        return ans;
    }
}
class Solution {
    public String longestWord(String[] words) {
        Trie trie=new Trie();
        trie.isEnd=true;    // as empty string also considered
        for(String word:words)
            trie.insert(word);
        return trie.findLongestWord(trie, "", new StringBuilder()); 
    }
}
