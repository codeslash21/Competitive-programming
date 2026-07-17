// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
// using pre-computed left and right profit
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length, minPrice=prices[0], maxPrice=prices[n-1], result=0;
        int[] leftProfit=new int[n], rightProfit=new int[n];
        for(int i=1;i<n;i++) {
            minPrice=Math.min(minPrice, prices[i]);
            leftProfit[i]=Math.max(leftProfit[i-1], prices[i]-minPrice);
        }
        for(int i=n-2;i>=0;i--) {
            maxPrice=Math.max(maxPrice, prices[i]);
            rightProfit[i]=Math.max(maxPrice-prices[i], rightProfit[i+1]);
        }
        for(int i=0;i<n;i++)
            result=Math.max(result, leftProfit[i]+rightProfit[i]);
        return result;
    }
}

// generalized dp for k transaction
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int maxProfit(int[] prices) {
        int k=2, n=prices.length;
        int[][] dp=new int[k+1][2];
        for(int i=1;i<=k;i++)
            dp[i][0]=-prices[0];
        for(int i=0;i<n;i++) {
            for(int j=1;j<=k;j++) {
                dp[j][0]=Math.max(dp[j][0], dp[j-1][1]-prices[i]);
                dp[j][1]=Math.max(dp[j][1], dp[j][0]+prices[i]);
            }
        }
        return dp[k][1];
    }
}
