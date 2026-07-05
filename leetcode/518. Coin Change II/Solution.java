// https://leetcode.com/problems/coin-change-ii/description/
// using recursion
// t.c.=O(2^max(n, a/m)), s.c.=O(max(n, a/m))
class Solution {
    public int change(int amount, int[] coins) {
        return dfs(amount, 0, coins);
    }
    private int dfs(int amount, int idx, int[] coins) {
        if(amount==0)   return 1;
        if(amount<0 || idx>=coins.length)   return 0;
        return dfs(amount, idx+1, coins) + dfs(amount-coins[idx], idx, coins);
    }
}

// using dp (bottom-up)
// t.c.=O(n*a), s.c.=O(n*a)
class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n+1][amount+1];
        for(int i=0;i<=n;i++)   dp[i][0]=1;
        for(int i=n-1;i>=0;i--)
            for(int j=1;j<=amount;j++)
                if(coins[i]>j)
                    dp[i][j]=dp[i+1][j];
                else
                    dp[i][j]=dp[i+1][j]+dp[i][j-coins[i]];
        return dp[0][amount];
    }
}
