// https://leetcode.com/problems/missing-element-in-sorted-array/description/
// using linear algorithm
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int missingElement(int[] nums, int k) {
        int len=nums.length, idx=0, next=nums[0], missed=0;
        while(idx<len) {
            if(next==nums[idx])
                idx++;
            else {
                missed++;
                if(missed==k)
                    return next;
            }
            next++;
        }
        return (k-missed)+nums[len-1];
    }
}

// using binary search
// t.c.=O(logn), s.c.=O(1)
class Solution {
    public int missingElement(int[] nums, int k) {
        int len=nums.length, left=0, right=len-1;
        while(left<=right) {
            int mid=left+(right-left)/2;
            if(nums[mid]-nums[0]-mid<k)
                left=mid+1;
            else 
                right=mid-1;
        }
        return k+nums[0]+right;
    }
}
