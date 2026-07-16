// https://neetcode.io/problems/new-21-game/solution
// using dp
// t.c.=O(n), s.c.=O(maxPts)
class Solution {
    public double new21Game(int n, int k, int maxPts) {
        double[] dp = new double[n + 1];
        dp[0] = 1.0;
        for (int i = 1; i <= n; i++)
            // Sum probabilities from all scores that can reach i
            for (int j = Math.max(0, i - maxPts); j < Math.min(i, k); j++) {
                dp[i] += dp[j] / maxPts;
            }
        // Sum probabilities for all valid final scores
        double result = 0.0;
        for (int i = k; i <= n; i++)
            result += dp[i];
        return result;
    }
}

// using sliding window
// t.c.=O(n), s.c.=O(n)
class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if(k==0 || n>=(k-1+maxPts))    return 1.0;
        double[] dp = new double[n + 1];
        double result = 0.0, sum=1.0;
        dp[0] = 1.0;
        for (int i = 1; i <= n; i++) {
            if(i-maxPts>0)  sum-=dp[i-maxPts-1];
            dp[i]=sum/maxPts;
            if(i<k) sum+=dp[i];
        }
        // Sum probabilities for all valid final scores
        for (int i = k; i <= n; i++)
            result += dp[i];
        return result;
    }
}
