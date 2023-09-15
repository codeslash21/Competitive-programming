// Using brute-force
// t.c.=O(n^n), s.c.=O(n)
class Solution {
    public int maxProfit(int[] prices) {
        return cal(prices, 0);
    }
    private int cal(int[] prices, int s) {
        if(s>=prices.length)
            return 0;
        int max=0;
        for(int start=s;start<prices.length;start++) {
            for(int i=start+1; i<prices.length;i++) {
                if(prices[start]<prices[i]) {
                    int profit=cal(prices, i+1)+prices[i]-prices[start];
                    if(profit>max)
                        max=profit;
                }
            }
        }
        return max;
    }
}

// using peak-valley approach, one pass
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int maxProfit(int[] prices) {
        int i=0, n=prices.length;
        int valley=prices[0], peak=prices[0], maxProfit=0;
        while(i<n-1) {
            while(i<n-1 && prices[i]>prices[i+1])
                i++;
            valley=prices[i];
            while(i<n-1 && prices[i]<=prices[i+1])
                i++;
            peak=prices[i];
            maxProfit+=peak-valley;
        }
        return maxProfit;
    }
}

// Simplifying the above concepts
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int maxProfit(int[] prices) {
        int max=0;
        for(int i=1;i<prices.length;i++)
            if(prices[i]>prices[i-1])
                max+=prices[i]-prices[i-1];
        return max;
    }
}
