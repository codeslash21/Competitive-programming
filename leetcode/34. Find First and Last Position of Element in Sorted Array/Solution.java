// Using binary search
// t.c.=O(logn), s.c.=O(1)
class Solution {
    int left=-1, right=-1;
    public void binSearch(int[] nums, int start, int end, int target, boolean first) {
        if(start>end)
            return;
        int mid=(start+end)/2;
        if(nums[mid]==target) {
            if(first) {
                left=mid;
                binSearch(nums, start, mid-1, target, first);
            }
            else {
                right=mid;
                binSearch(nums, mid+1, end, target, first);
            }
        }
        else if(nums[mid]<target)
            binSearch(nums, mid+1, end, target, first);
        else
            binSearch(nums, start, mid-1, target, first);
    }
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        binSearch(nums, 0, n-1, target, true);
        binSearch(nums, 0, n-1, target, false);
        return new int[]{left, right};
    }
}
