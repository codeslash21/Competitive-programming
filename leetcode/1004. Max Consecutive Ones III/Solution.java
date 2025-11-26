// https://leetcode.com/problems/max-consecutive-ones-iii/description/
// sliding window
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int longestOnes(int[] nums, int k) {
        int len=nums.length, maxLen=0, freqZero=0, left=0, right=0;
        while(right<len) {
            if(nums[right++]==0)
                freqZero++;
            while(left<right && freqZero>k) 
                freqZero-=nums[left++]==0?1:0;
            maxLen=Math.max(maxLen, right-left);
        }
        return maxLen;
    }
}
