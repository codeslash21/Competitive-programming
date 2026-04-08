// https://leetcode.com/problems/best-sightseeing-pair/description/
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int len=values.length, maxScore=0, rightMax=Integer.MIN_VALUE;
        for(int i=len-1;i>=0;i--) {
            int score=values[i]+i+rightMax;
            maxScore=Math.max(maxScore, score);
            rightMax=Math.max(rightMax, values[i]-i);
        }
        return maxScore;
    }
}
