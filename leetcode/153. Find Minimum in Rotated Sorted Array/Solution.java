// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
// t.c.=O(logn), s.c.=O(1)
class Solution {
    private int findRotationIndex(int[] nums) {
        int left=0, right=nums.length-1;
        if(nums[0]<=nums[nums.length-1])
            return 0;
        while(left<=right) {
            int mid=left+(right-left)/2;
            if(nums[mid]>nums[mid+1])
                return mid+1;
            if(nums[mid]>=nums[left])
                left=mid+1;
            else
                right=mid-1;
        }
        return 0;
    }
    public int findMin(int[] nums) {
        return nums[findRotationIndex(nums)];
    }
}
