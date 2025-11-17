// https://leetcode.com/problems/minimum-time-to-make-rope-colorful/description/
// linear scan
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int minCost(String colors, int[] neededTime) {
        int len=neededTime.length, sum=0, max=0, i=0, j=0, cnt=0, res=0;
        while(j<len) {
            while(j<len && colors.charAt(i)==colors.charAt(j))
                j++;
            max=0; cnt=j-i; sum=0;
            for(int k=i;k<j;k++) {
                sum+=neededTime[k];
                max=Math.max(max, neededTime[k]);
            }
            if(cnt>1)
                res+=(sum-max);
            i=j;
        }
        return res;
    }
}
