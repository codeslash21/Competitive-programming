// https://leetcode.com/problems/missing-number/description/
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int missingNumber(int[] nums) {
        int len=nums.length, missing=len;
        for(int i=0;i<len;i++)
            missing^=i^nums[i];
        return missing;
    }
}
