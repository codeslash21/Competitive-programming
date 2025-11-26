// https://leetcode.com/problems/subarray-product-less-than-k/description/
// sliding window
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int len=nums.length, left=0, right=0, prod=1, subArrayCnt=0;
        while(right<len) {
            prod*=nums[right++];
            while(left<right && prod>=k)
                prod/=nums[left++];
            subArrayCnt+=(right-left);
        }
        return subArrayCnt;
    }
}
