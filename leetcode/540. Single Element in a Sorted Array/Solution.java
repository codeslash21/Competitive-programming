// https://leetcode.com/problems/single-element-in-a-sorted-array/description/
// binary search, t.c.=O(logn), s.c.=O(1)
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int len=nums.length, left=0, right=len-1;
        while(left<right) {
            int mid=left+(right-left)/2;
            if(mid%2>0) mid--;
            if(nums[mid]==nums[mid+1])
                left=mid+2;
            else
                right=mid;
        }
        return nums[left];
    }
}
