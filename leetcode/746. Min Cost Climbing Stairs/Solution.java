// https://leetcode.com/problems/min-cost-climbing-stairs/description/
// using dp (bottom-up)
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length, prev1=0, prev2=0;
        for(int i=2;i<=n;i++) {
            int current=Math.min(prev1+cost[i-1], prev2+cost[i-2]);
            prev2=prev1;
            prev1=current;
        }
        return prev1;
    }
}
