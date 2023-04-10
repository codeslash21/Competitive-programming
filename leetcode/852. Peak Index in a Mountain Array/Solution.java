// binary search recursive approach
// t.c.=O(logn), s.c.=O(logn)
class Solution {
    private int search(int[] nums, int l, int r) {
        if(l==r)
            return l;
        int mid=(l+r)/2;
        if(nums[mid]>nums[mid+1])
            return search(nums, l, mid);
        return search(nums, mid+1, r);
    }
    public int peakIndexInMountainArray(int[] nums) {
        return search(nums, 0, nums.length-1);
    }
}

// binary search iterative approach
// t.c.=O(logn), s.c.=O(1)
class Solution {
    public int peakIndexInMountainArray(int[] nums) {
        int n=nums.length;
        int l=0, r=n-1;
        while(l<r) {
            int mid = (l+r)/2;
            if(nums[mid]>nums[mid+1])
                r=mid;
            else 
                l=mid+1;
        }
        return l;
    }
}
