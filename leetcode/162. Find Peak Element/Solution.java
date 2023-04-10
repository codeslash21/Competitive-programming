// Using linear scan
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n-1;i++)
            if(nums[i]>nums[i+1])
                return i;
        return n-1;
    }
}

// Using recursive binary search
// t.c.=O(logn), s.c.=O(logn)
class Solution {
    private int search(int[] nums, int left, int right) {
        if(left==right)
            return left;
        int mid=(left+right)/2;
        if(nums[mid]>nums[mid+1])
            return search(nums, left, mid);
        return search(nums, mid+1, right);
    }
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        return search(nums, 0, n-1);
    }
}

// binary search iterative approach
// t.c.=O(logn), s.c.=O(1)
class Solution {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        int l=0, r=n-1;
        while(l<r) {
            int mid=(l+r)/2;
            if(nums[mid]>nums[mid+1])
                r=mid;
            else
                l=mid+1;
        }
        return l;
    }
}
