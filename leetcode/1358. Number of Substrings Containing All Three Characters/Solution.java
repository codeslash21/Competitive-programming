// https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/
// sliding window
// t.c.=O(n), s.c.=O(1)
class Solution {
    public boolean validSubstring(int[] freq) {
        return freq[0]>0 && freq[1]>0 && freq[2]>0;
    }
    public int numberOfSubstrings(String s) {
        int len=s.length(), left=0, right=0, res=0;
        int[] freq=new int[3];
        while(right<len) {
            freq[s.charAt(right)-'a']++;
            while(validSubstring(freq)) {
                res+=(len-right);
                freq[s.charAt(left++)-'a']--;
            }
            right++;
        }
        return res;
    }
}
