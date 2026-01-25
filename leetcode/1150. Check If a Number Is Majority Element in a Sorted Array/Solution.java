// https://leetcode.com/problems/check-if-a-number-is-majority-element-in-a-sorted-array/description/
// using two binary search for finding lower and upper bound of the target
// t.c.=O(logn), s.c.=O(1)
class Solution {
    public int lowerBound(int[] nums, int target) {
        int len=nums.length, left=0, right=len-1, lowerIdx=len;
        while(left<=right) {
            int mid=left+(right-left)/2;
            if(nums[mid]>=target) {
                right=mid-1;
                lowerIdx=mid;
            } else
                left=mid+1;
        }
        return lowerIdx;
    }
    public int upperBound(int[] nums, int target) {
        int len=nums.length, left=0, right=len-1, upperIdx=len;
        while(left<=right) {
            int mid=left+(right-left)/2;
            if(nums[mid]>target) {
                right=mid-1;
                upperIdx=mid;
            } else
                left=mid+1;
        }
        return upperIdx;
    }
    public boolean isMajorityElement(int[] nums, int target) {
        return upperBound(nums, target)-lowerBound(nums, target)>nums.length/2;
    }
}

// using one binary search
// t.c.=O(logn), s.c.=O(1)
class Solution {
    public int lowerBound(int[] nums, int target) {
        int len=nums.length, left=0, right=len-1, lowerIdx=len;
        while(left<=right) {
            int mid=left+(right-left)/2;
            if(nums[mid]>=target) {
                right=mid-1;
                lowerIdx=mid;
            } else
                left=mid+1;
        }
        return lowerIdx;
    }
    public boolean isMajorityElement(int[] nums, int target) {
        int len=nums.length, lowerIdx = lowerBound(nums, target);
        return lowerIdx+len/2<len && nums[lowerIdx+len/2]==target;
    }
}
