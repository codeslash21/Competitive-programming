// https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/description/
// using dp
// t.c.=O(n^2), s.c.=O(n)
class Solution {
    public int minTaps(int n, int[] ranges) {
        final int INF=(int) 1e9;
        int[] dp=new int[n+1];
        Arrays.fill(dp, INF);
        dp[0]=0;
        for(int i=0;i<=n;i++) {
            int tapStart=Math.max(i-ranges[i], 0), tapEnd=Math.min(i+ranges[i], n);
            for(int j=tapStart;j<=tapEnd;j++)
                dp[tapEnd]=Math.min(dp[tapEnd], dp[j]+1);
        }
        if(dp[n]==INF)  return -1;
        return dp[n];
    }
}

// using greedy
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] maxRange=new int[n+1];
        int taps=0, currEnd=0, nextEnd=0;
        for(int i=0;i<=n;i++) {
            int start=Math.max(0, i-ranges[i]), end=Math.min(n, i+ranges[i]);
            maxRange[start]=Math.max(maxRange[start], end);
        }
        for(int i=0;i<=n;i++) {
            if(i>nextEnd)   return -1;
            nextEnd=Math.max(nextEnd, maxRange[i]);
            if(currEnd==i) {
                taps++;
                currEnd=nextEnd;
            }
            if(currEnd>=n)  break;
        }
        return taps;
    }
}
