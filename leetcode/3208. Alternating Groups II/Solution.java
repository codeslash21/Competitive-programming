// https://leetcode.com/problems/alternating-groups-ii/description/
// expand the array + sliding window
// t.c.=O(n+k), s.c.=O(n+k)
class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int len=colors.length, extendedLen=len+k-1, cnt=0, idx=0, left=0, right=1;
        int[] extendedColors=new int[extendedLen];
        for(idx=0;idx<len;idx++)
            extendedColors[idx]=colors[idx];
        for(int i=0;i<k-1;i++)
            extendedColors[idx++]=colors[i];
        while(right<extendedLen) {
            if(extendedColors[right]==extendedColors[right-1]) {
                left=right;
                right++;
            } else {
                right++;
                if(right-left==k) {
                    left++;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}

// one pass
// t.c.=O(n+k), s.c.=O(1)
class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int len=colors.length, extendedLen=len+k-1, res=0, alternatingEleCnt=1, lastColor=colors[0];
        for(int i=1;i<extendedLen;i++) {
            int idx=i%len;
            if(colors[idx]==lastColor)
                alternatingEleCnt=1;
            else {
                alternatingEleCnt++;
                if(alternatingEleCnt>=k)
                    res++;
            }
            lastColor=colors[idx];
        }
        return res;
    }
}
