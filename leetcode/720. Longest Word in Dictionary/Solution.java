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
