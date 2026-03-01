// https://leetcode.com/problems/concatenation-of-array/description/
// linear algo
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int[] getConcatenation(int[] nums) {
        int len=nums.length;
        int[] ans=new int[2*len];
        for(int i=0;i<len;i++) {
            ans[i]=nums[i];
            ans[i+len]=nums[i];
        }
        return ans;
    }
}
