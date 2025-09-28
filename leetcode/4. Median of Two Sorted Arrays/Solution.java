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
        int len1=nums1.length, len2=nums2.length, totalLength=len1+len2, parity=totalLength%2;
        if(len2>len1)
            return findMedianSortedArrays(nums2, nums1);
        int left=0, right=len2;
        while(left<=right) {
            int secondIdx=left+(right-left)/2;
            int firstIdx=(totalLength-parity)/2-secondIdx;
            int maxLeftA=firstIdx>0?nums1[firstIdx-1]:Integer.MIN_VALUE;
            int minRightA=firstIdx<len1?nums1[firstIdx]:Integer.MAX_VALUE;
            int maxLeftB=secondIdx>0?nums2[secondIdx-1]:Integer.MIN_VALUE;
            int minRightB=secondIdx<len2?nums2[secondIdx]:Integer.MAX_VALUE;
            if(maxLeftA<=minRightB && maxLeftB<=minRightA)
                if(parity==0)
                    return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB))/2.0;
                else
                    return (double)Math.min(minRightA, minRightB);
            else if(maxLeftA>minRightB)
                left=secondIdx+1;
            else
                right=secondIdx-1;
        }
        return 0.0;
    }
}
