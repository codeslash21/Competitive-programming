// Using three pointers and starting from end
// t.c.=O(m+n), s.c.=O(1)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1=nums1.length-1, p2=m-1, p3=n-1;
        while(p1>=0) {
            if(p3<0)
                break;
            if(p2>= 0 && nums1[p2]>nums2[p3])
                nums1[p1--]=nums1[p2--];
            else
                nums1[p1--]=nums2[p3--];
        }
    }
}
