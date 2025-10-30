// Using binary search
// t.c.=O(logn), s.c.=O(1)
class Solution {
    public int binarySearch(int[] nums, int target, boolean isFirst) {
        int len=nums.length, left=0, right=len-1;
        while(left<=right) {
            int mid=left+(right-left)/2;
            if(nums[mid]==target)
                if(isFirst) {
                    if(left==mid || nums[mid-1]!=target)
                        return mid;
                    right=mid-1;
                }
                else {
                    if(mid==right || nums[mid+1]!=target)
                        return mid;
                    left=mid+1;
                }
            else if(nums[mid]>target)
                right=mid-1;
            else
                left=mid+1;
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] res=new int[2];
        res[0]=binarySearch(nums, target, true);
        res[1]=binarySearch(nums, target, false);
        return res;
    }
}
