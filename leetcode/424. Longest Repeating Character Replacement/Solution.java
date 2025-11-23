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

// sliding window (slow)
// t.c.=O(m*n), s.c.=O(1)
class Solution {
    public int characterReplacement(String s, int k) {
        int len=s.length(), res=0;
        Set<Character> chars=new HashSet<>();
        for(int i=0;i<len;i++)
            chars.add(s.charAt(i));
        for(Character ch:chars) {
            int left=0, right=0, maxLen=0, charFreq=0;
            while(right<len) {
                if(s.charAt(right)==ch)
                    charFreq++;
                while(left<=right && right+1-left-charFreq>k)
                    if(s.charAt(left++)==ch)
                        charFreq--;
                maxLen=Math.max(maxLen, right+1-left);
                right++;
            }
            res=Math.max(res, maxLen);
        }
        return res;
    }
}

// sliding window (fast)
// t.c.=O(n), s.c.=O(m), m=number of distinct character in s
class Solution {
    public int characterReplacement(String s, int k) {
        int len=s.length(), res=0, maxLen=0, maxFreq=0, left=0, right=0;
        int[] freq=new int[26];
        while(right<len) {
            char ch=s.charAt(right++);
            freq[ch-'A']++;
            maxFreq=Math.max(maxFreq, freq[ch-'A']);
            while(left<right && right-left-maxFreq>k)
                freq[s.charAt(left++)-'A']--;
            maxLen=Math.max(maxLen, right-left);
        }
        return maxLen;
    }
}
