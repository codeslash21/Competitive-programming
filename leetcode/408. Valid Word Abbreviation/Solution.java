// https://leetcode.com/problems/valid-word-abbreviation/description/
// using two pointers
// t.c.=O(max(len1, len2)), s.c.=O(1), len1=len(word), len2=len(abbr)
class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int wordLen=word.length(), abbrLen=abbr.length(), idx1=0, idx2=0;
        while(idx1<wordLen && idx2<abbrLen) {
            char wordChar=word.charAt(idx1), abbrChar=abbr.charAt(idx2);
            if(wordChar==abbrChar) {
                idx1++; idx2++;
                continue;
            } else if(abbrChar=='0' || abbrChar>'9')
                return false;
            int start=idx2;
            while(idx2<abbrLen && abbr.charAt(idx2)<='9')
                idx2++;
            int num=Integer.valueOf(abbr.substring(start, idx2));
            idx1+=num;
        }
        return idx1==wordLen && idx2==abbrLen?true:false;
    }
}
