// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
// using recursion
// t.c.=O(2^n), s.c.=O(n)
class Solution {
    public int maxProfit(int[] prices) {
        return dfs(0, true, prices);
    }
    private int dfs(int idx, boolean canBuy, int[] prices) {
        if(idx>=prices.length)  return 0;
        int skip=dfs(idx+1, canBuy, prices);
        if(canBuy) {
            int buy=dfs(idx+1, false, prices)-prices[idx];
            return Math.max(buy, skip);
        } else {
            int sell=dfs(idx+2, true, prices)+prices[idx];
            return Math.max(sell, skip);
        }
    }
}

// using dp
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n+1][2];
        for(int i=n-1;i>=0;i--) 
            for(int canBut=0;canBut<2;canBut++) 
                if(canBut==0) {
                    int buy=dp[i+1][1]-prices[i];
                    int skip=dp[i+1][0];
                    dp[i][0]=Math.max(buy, skip);
                } else {
                    int sell=i+2<=n?dp[i+2][0]+prices[i]:prices[i];
                    int skip=dp[i+1][1];
                    dp[i][1]=Math.max(sell, skip);
                }
        return dp[0][0];
    }
}

// space optimized version of above approach
// t.c.=O(n), s.c.=O(1)
public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp1_buy = 0, dp1_sell = 0;
        int dp2_buy = 0;
        for (int i = n - 1; i >= 0; i--) {
            int dp_buy = Math.max(dp1_sell - prices[i], dp1_buy);
            int dp_sell = Math.max(dp2_buy + prices[i], dp1_sell);
            dp2_buy = dp1_buy;
            dp1_buy = dp_buy;
            dp1_sell = dp_sell;
        }
        return dp1_buy;
    }
}
