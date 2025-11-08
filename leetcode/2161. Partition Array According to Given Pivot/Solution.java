// https://leetcode.com/problems/partition-array-according-to-given-pivot/description/
// using two pointers
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int len=nums.length, lessIdx=0, greaterIdx=len-1;
        int[] res=new int[len];
        for(int i=0,j=len-1;i<len;i++,j--) {
            if(nums[i]<pivot) 
                res[lessIdx++]=nums[i];
            if(nums[j]>pivot)
                res[greaterIdx--]=nums[j];
        }
        while(lessIdx<=greaterIdx)
            res[lessIdx++]=pivot;
        return res;
    }
}
