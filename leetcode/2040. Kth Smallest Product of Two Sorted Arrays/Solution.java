// https://leetcode.com/problems/kth-smallest-product-of-two-sorted-arrays/description/
// binary search + binary search
// t.c.=O(n1logn2logC), s.c.=O(1), n1=len(nums1), n2=len(nums2), C=2*10^10
class Solution {
    public long countLessThanEqual(int[] nums, long multiplier, long target) {
        int len=nums.length, left=0, right=len-1;
        while(left<=right) {
            int mid=left+(right-left)/2;
            long prod=nums[mid]*multiplier;
            if((multiplier>=0 && prod<=target) || (multiplier<0 && prod>target))
                left=mid+1;
            else
                right=mid-1;
        }
        return multiplier>=0?left:len-left;
    }
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        int len1=nums1.length, len2=nums2.length;
        long left=(long)-10e10, right=(long)10e10;
        while(left<right) {
            long mid=left+(right-left)/2, count=0;
            for(int i=0;i<len1;i++)
                count+=countLessThanEqual(nums2, nums1[i], mid);
            if(count<k)
                left=mid+1;
            else
                right=mid;
        }
        return left;
    }
}

