// https://leetcode.com/problems/last-stone-weight-ii/description/
// using recursion
// t.c.=O(2^n), s.c.=O(min(n,m)), m=sum(stones)/2
class Solution {
    public int lastStoneWeightII(int[] stones) {
        int stoneSum=Arrays.stream(stones).sum();
        return dfs(0, 0, stones, stoneSum/2, stoneSum);
    }
    private int dfs(int idx, int total, int[] stones, int target, int stoneSum) {
        if(total>=target || idx==stones.length)
            return Math.abs(total-(stoneSum-total));
        return Math.min(dfs(idx+1, total, stones, target, stoneSum),
                        dfs(idx+1, total+stones[idx], stones, target, stoneSum));
    }
}

// using bottom-up
// t.c.=O(m*n), s.c.=O(m*n)
class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n=stones.length, stoneSum=Arrays.stream(stones).sum(), target=stoneSum/2;
        int[][] dp=new int[n+1][target+1];
        for(int i=1;i<=n;i++)
            for(int t=1;t<=target;t++)
                if(stones[i-1]<=t)
                    dp[i][t]=Math.max(dp[i-1][t], dp[i-1][t-stones[i-1]]+stones[i-1]);
                else
                    dp[i][t]=dp[i-1][t];
        return stoneSum - 2 * dp[n][target];
    }
}
