// https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/description/
// using sliding window
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int minimumRecolors(String blocks, int k) {
        int len=blocks.length(), cnt=0, maxCnt=0;
        for(int i=0;i<len;i++) {
            cnt+=blocks.charAt(i)=='B'?1:0;
            if(i>=k)
                cnt-=blocks.charAt(i-k)=='B'?1:0;
            maxCnt=Math.max(maxCnt, cnt);
        }
        return k-maxCnt;
    }
}
