// https://leetcode.com/problems/max-consecutive-ones-ii/description/
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int len=nums.length, left=0, right=0, lastZero=0, countZero=0, maxLen=0;
        while(right<len) {
            if(nums[right]==0)
                countZero++;
            if(countZero>1) {
                left=lastZero+1;
                countZero--;
            }
            maxLen=Math.max(maxLen, right+1-left);
            if(nums[right]==0)
                lastZero=right;
            right++;
        }
        return maxLen;
    }
}
