// https://leetcode.com/problems/frequency-of-the-most-frequent-element/description/
// sliding window
// t.c.=O(nlogn), s.c.=O(logn)
class Solution {
    public int maxFrequency(int[] nums, int k) {
        int len=nums.length, res=0, left=0, right=0;
        long sum=0;
        Arrays.sort(nums);
        while(right<len) {
            int target=nums[right++];
            sum+=target;
            if((long)(right-left)*target-sum>k)
                sum-=nums[left++];
            res=Math.max(res, right-left);
        }
        return res;
    }
}
