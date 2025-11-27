// https://leetcode.com/problems/take-k-of-each-character-from-left-and-right/description/
// sliding window
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int takeCharacters(String s, int k) {
        int len=s.length(), left=0, right=0, maxWindow=0;
        int[] freq=new int[3], windowFreq=new int[3];
        for(char ch:s.toCharArray())
            freq[ch-'a']++;
        for(int i=0;i<3;i++)
            if(freq[i]<k)
                return -1;
            else
                freq[i]-=k;
        while(right<len) {
            char curr=s.charAt(right);
            windowFreq[curr-'a']++;
            while(left<=right && windowFreq[curr-'a']>freq[curr-'a'])
                windowFreq[s.charAt(left++)-'a']--;
            maxWindow=Math.max(maxWindow, right+1-left);
            right++;
        }
        return len-maxWindow;
    }
}
