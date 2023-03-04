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
