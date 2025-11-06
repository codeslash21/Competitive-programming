// https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/description/
// using two pointers
// t.c.=O(m+n), s.c.=O(m+n)
class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int len1=nums1.length, len2=nums2.length, idx1=0, idx2=0, idx3=0;
        int[][] res=new int[len1+len2][2];
        while(idx1<len1 && idx2<len2) {
            if(nums1[idx1][0]==nums2[idx2][0]) {
                res[idx3]=nums1[idx1++];
                res[idx3++][1]+=nums2[idx2++][1];
            } else if(nums1[idx1][0]<nums2[idx2][0]) 
                res[idx3++]=nums1[idx1++];
            else 
                res[idx3++]=nums2[idx2++];
        }
        while(idx1<len1) 
            res[idx3++]=nums1[idx1++];
        while(idx2<len2)
            res[idx3++]=nums2[idx2++];
        return Arrays.copyOfRange(res, 0, idx3);
    }
}
