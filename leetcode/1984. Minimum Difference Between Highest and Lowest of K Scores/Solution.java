// https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/description/
// using sliding window
// t.c.=O(nlogn), s.c.=O(logn)
class Solution {
    public int minimumDifference(int[] nums, int k) {
        int len=nums.length, left=0, right=k-1, res=Integer.MAX_VALUE;
        Arrays.sort(nums);
        while(right<len) 
            res=Math.min(res, nums[right++]-nums[left++]);
        return res;
    }
}
