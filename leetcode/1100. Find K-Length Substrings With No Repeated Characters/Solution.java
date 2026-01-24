// https://leetcode.com/problems/find-k-length-substrings-with-no-repeated-characters/description/
// t.c.=O(n), s.c.=O(k)
class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        int len=s.length(), right=0, maxCnt=0;
        Map<Character, Integer> charFreq=new HashMap<>();
        while(right<Math.min(len, k-1))
            charFreq.put(s.charAt(right), charFreq.getOrDefault(s.charAt(right++), 0)+1);
        while(right<len) {
            char currChar=s.charAt(right);
            charFreq.put(currChar, charFreq.getOrDefault(currChar, 0)+1);
            if(right>=k) {
                char removedChar=s.charAt(right-k);
                charFreq.put(removedChar, charFreq.get(removedChar)-1);
                if(charFreq.get(removedChar)==0)
                    charFreq.remove(removedChar);
            }
            if(charFreq.size()==k)
                maxCnt++;
            right++;
        }
        return maxCnt;
    }
}
