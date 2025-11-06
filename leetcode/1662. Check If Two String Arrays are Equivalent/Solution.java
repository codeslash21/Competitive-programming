// https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/description/
// t.c.=O(n), s.c.=O(n), n=max(len(word1), len(word2))
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String str2=String.join("", word2);
        int len=str2.length(), idx=0;
        for(String word:word1)
            for(char ch:word.toCharArray()) {
                if(idx>=len || ch!=str2.charAt(idx))
                    return false;
                idx++;
            }
        return idx==len;
    }
}
