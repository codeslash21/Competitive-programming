// https://leetcode.com/problems/integer-break/description/
// using dp (bottom-up)
// t.c.=O(n^2), s.c.=O(n)
class Solution {
    public int integerBreak(int n) {
        int[] dp=new int[n+1];
        dp[2]=1;
        for(int j=3;j<=n;j++)
            for(int i=1;i<j;i++)
                dp[j]=Math.max(dp[j], i*Math.max(j-i, dp[j-i]));
        return dp[n];
    }
}
