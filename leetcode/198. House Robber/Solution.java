// Using dp iterative approach
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp = new int[n+1];
        dp[0]=0; dp[1]=nums[0];
        for(int i=2;i<=n;i++)
            dp[i]=Math.max(dp[i-1], dp[i-2]+nums[i-1]);
        return dp[n];
    }
}

// Without using extra space
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int first = 0, second = nums[0], curr=0;
        for(int i=2;i<=n;i++){
            curr = Math.max(second, first+nums[i-1]);
            first=second;
            second=curr;
        }
        return second;
    }
}
