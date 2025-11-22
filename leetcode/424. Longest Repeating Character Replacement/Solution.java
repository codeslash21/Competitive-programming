// https://leetcode.com/problems/longest-repeating-character-replacement/description/
// sliding window + binary search
// t.c.=O(nlogn), s.c.=O(1)
class Solution {
    public boolean canMakeValidSubstring(String s, int substringLen, int k) {
        int[] freqMap=new int[26];
        int maxFreq=0, len=s.length(), left=0, right=0;
        while(right<len) {
            char ch=s.charAt(right++);
            freqMap[ch-'A']++;
            if(right-left>substringLen)
                freqMap[s.charAt(left++)-'A']--;
            maxFreq=Math.max(maxFreq, freqMap[ch-'A']);
            if(substringLen-maxFreq<=k)
                return true;
        }
        return false;
    }
    public int characterReplacement(String s, int k) {
        int len=s.length(), left=1, right=len;
        while(left<=right) {
            int mid=left+(right-left)/2;
            if(canMakeValidSubstring(s, mid, k))
                left=mid+1;
            else
                right=mid-1;
        }
        return left-1;
    }
}
