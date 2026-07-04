// https://leetcode.com/problems/target-sum/description/
// using recursion
// t.c.=O(2^n), s.c.=O(n)
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(0, 0, nums, target);
    }
    private int dfs(int idx, int total, int[] nums, int target) {
        if(idx==nums.length)
            return total==target?1:0;
        return dfs(idx+1, total+nums[idx], nums, target)+
               dfs(idx+1, total-nums[idx], nums, target);
    }
}

// using dp
// t.c.=O(n*m), s.c.=O(n*m)
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        Map<Integer, Integer>[] dp=new HashMap[n+1];
        for(int i=0;i<=n;i++)   dp[i]=new HashMap<>();
        dp[0].put(0, 1);
        for(int i=0;i<n;i++) {
            for(Map.Entry<Integer, Integer> entry:dp[i].entrySet()) {
                int total=entry.getKey(), count=entry.getValue();
                dp[i+1].put(total+nums[i], dp[i+1].getOrDefault(total+nums[i], 0)+count);
                dp[i+1].put(total-nums[i], dp[i+1].getOrDefault(total-nums[i], 0)+count);
            }
        }
        return dp[n].getOrDefault(target, 0);
    }
}
