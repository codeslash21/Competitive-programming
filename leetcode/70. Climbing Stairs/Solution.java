// using dp
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int climbStairs(int n) {
        if(n==1)
            return 1;
        int[] dp = new int[n+1];
        dp[1]=1; dp[2]=2;
        for(int i=3; i<=n; i++)
            dp[i]=dp[i-1]+dp[i-2];
        return dp[n];
    }
}

// using fibonacci
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int climbStairs(int n) {
        if(n==1)
            return 1;
        int first=1, second=2;
        for(int i=3; i<=n; i++){
            int val=first+second;
            first=second;
            second=val;
        }
        return second;
    }
}
