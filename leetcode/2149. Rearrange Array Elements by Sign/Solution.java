// https://leetcode.com/problems/rearrange-array-elements-by-sign/description/
// using two pointers
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int len=nums.length, currIdx=0, postIdx=-2, negIdx=-1;
        int[] modifiedNums=new int[len];
        while(currIdx<len) 
            if(nums[currIdx]>0)
                modifiedNums[postIdx+=2]=nums[currIdx++];
            else
                modifiedNums[negIdx+=2]=nums[currIdx++];
        return modifiedNums;
    }
}
