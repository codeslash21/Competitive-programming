// https://leetcode.com/problems/number-of-zero-filled-subarrays/description/
// t.c.=O(n), s.c.=O(1)
class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int len=nums.length, l=0, r=0;
        long res=0;
        while(r<len) {
            if(nums[r]!=0)
                l=r+1;
            else 
                res+=(r-l+1);
            r++;
        }
        return res;
    }
}
