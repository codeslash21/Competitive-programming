// https://leetcode.com/problems/maximum-beauty-of-an-array-after-applying-operation/description/
// sorting + sliding window
// t.c.=O(nlogn), s.c.=O(logn)
class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int len=nums.length, left=0, right=0;
        while(right<len)
            if(nums[right++]-nums[left]>2*k)
                left++;
        return len-left;
    }
}
