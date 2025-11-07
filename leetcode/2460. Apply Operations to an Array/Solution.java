// https://leetcode.com/problems/apply-operations-to-an-array/description/
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int[] applyOperations(int[] nums) {
        int len=nums.length, right=0, curr=0;
        for(int i=0;i<len-1;i++)
            if(nums[i]==nums[i+1]) {
                nums[i]*=2;
                nums[i+1]=0;
            }
        while(curr<len) {
            if(nums[curr]!=0) {
                int num=nums[right];
                nums[right++]=nums[curr];
                nums[curr]=num;
            }
            curr++;
        }
        return nums;
    }
}
