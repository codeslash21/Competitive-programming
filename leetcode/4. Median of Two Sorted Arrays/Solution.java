// Using merge procedure
// t.c.=O(m+n), s.c.=O(m+n)
class Solution {
    int n1, n2, l=0, r=0;
    private int getMin(int[] nums1, int[] nums2) {
        if(r==n2 || (l<n1 && nums1[l]<nums2[r])) 
            return nums1[l++];
        else 
            return nums2[r++];
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        n1=nums1.length; n2=nums2.length;
        int first=0, mid=(n1+n2+1)/2, rem=(n1+n2)%2;
        while((l+r)<mid) 
            first = getMin(nums1, nums2);
        return rem==1?first:(float)(first+getMin(nums1, nums2))/2;
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
