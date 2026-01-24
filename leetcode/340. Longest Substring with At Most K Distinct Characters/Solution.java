// https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/description/
// t.c.=O(n), s.c.=O(min(n,k))
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> uniqueChars=new HashMap<>();
        int len=s.length(), left=0, right=0, maxLen=0;
        while(right<len) {
            uniqueChars.put(s.charAt(right), right);
            while(uniqueChars.size()>k) {
                if(uniqueChars.get(s.charAt(left))==left)
                    uniqueChars.remove(s.charAt(left));
                left++;
            }
            maxLen=Math.max(maxLen, right+1-left);
            right++;
        }
        return maxLen;
    }
}
