// Using recursion
//t.c.=O2^n), s.c.=O(n)
class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length, total_sum=0;
        for(int e:nums)
            total_sum+=e;
        if(total_sum%2!=0)
            return false;
        int subsetSum=total_sum/2;
        return dfs(nums, n, subsetSum);
    }
    public boolean dfs(int[] nums, int n, int subsetSum) {
        if(subsetSum==0)
            return true;
        if(n==0 || subsetSum<0)
            return false;
        return dfs(nums, n-1, subsetSum-nums[n-1]) || dfs(nums, n-1, subsetSum);
    }
}

// Using top-down approach dp
// t.c.=O(mn), s.c.=O(mn), m=subsetSum
class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length, total_sum=0;
        for(int e:nums)
            total_sum+=e;
        if(total_sum%2!=0)
            return false;
        int subsetSum=total_sum/2;
        Boolean[][] memo = new Boolean[n+1][subsetSum+1];
        return dfs(nums, n, subsetSum, memo);
    }
    public boolean dfs(int[] nums, int n, int subsetSum, Boolean[][] memo) {
        if(subsetSum==0)
            return true;
        if(n==0 || subsetSum<0)
            return false;
        if(memo[n][subsetSum] != null)
            return memo[n][subsetSum];
        boolean result = dfs(nums, n-1, subsetSum-nums[n-1], memo) || 
                            dfs(nums, n-1, subsetSum, memo);
        memo[n][subsetSum]=result;
        return result;
    }
}

// Using bottom-up approach dp
// t.c.=O(mn), s.c.=O(mn)
class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length, total_sum=0;
        for(int e:nums)
            total_sum+=e;
        if(total_sum%2!=0)
            return false;
        int subsetSum=total_sum/2;
        boolean[][] memo = new boolean[n+1][subsetSum+1];
        memo[0][0]=true;
        for(int i=1;i<=n;i++) {
            int curr=nums[i-1];
            for(int j=0;j<=subsetSum;j++) {
                if(j<curr)
                    memo[i][j]=memo[i-1][j];
                else
                    memo[i][j]=memo[i-1][j] || memo[i-1][j-curr];
            }
        }
        return memo[n][subsetSum];
    }
}

