// https://leetcode.com/problems/search-insert-position/description/
class Solution {
    public int searchInsert(int[] nums, int target) {
        int len=nums.length, left=0, right=len-1;
        while(left<=right) {
            int mid=left+(right-left)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]>target)
                right=mid-1;
            else
                left=mid+1;
        }
        return left;
    }
}
