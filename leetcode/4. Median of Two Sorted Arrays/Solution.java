// Using merge procedure
// t.c.=O(m+n), s.c.=O(1)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1=nums1.length, len2=nums2.length, mid=(len1+len2)/2;
        int firstIdx=0, secondIdx=0, median1=0, median2=0;
        for(int i=0;i<=mid;i++) {
            median2=median1;
            if(firstIdx<len1 && secondIdx<len2) {
                if(nums1[firstIdx]<=nums2[secondIdx])
                    median1=nums1[firstIdx++];
                else
                    median1=nums2[secondIdx++];
            } else if(firstIdx<len1)
                median1=nums1[firstIdx++];
            else
                median1=nums2[secondIdx++];
        }
        if((len1+len2)%2>0)
            return (double)median1;
        return (median1+median2)/2.0;
    }
}

// using binary search
// t.c.=O(log(min(m,n))), s.c.=O(1)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length)
                return findMedianSortedArrays(nums2, nums1);
        int m=nums1.length, n=nums2.length, left=0, right=m;
        while(left<=right) {
            int partA=(left+right)/2, partB=(m+n+1)/2-partA;
            int maxLeftA=partA==0?Integer.MIN_VALUE:nums1[partA-1];
            int minRightA=partA==m?Integer.MAX_VALUE:nums1[partA];
            int maxLeftB=partB==0?Integer.MIN_VALUE:nums2[partB-1];
            int minRightB=partB==n?Integer.MAX_VALUE:nums2[partB];
            if(maxLeftA<=minRightB && maxLeftB<=minRightA)
                if((m+n)%2==0)
                    return (Math.max(maxLeftA, maxLeftB)+Math.min(minRightA, minRightB))/2.0;
                else
                    return Math.max(maxLeftA, maxLeftB);
            else if(maxLeftA>minRightB)
                right=partA-1;
            else
                left=partA+1;
        }
        return 0.0;
    }
}
