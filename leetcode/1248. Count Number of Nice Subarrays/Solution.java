// https://leetcode.com/problems/count-number-of-nice-subarrays/description/
// sliding window
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int len=nums.length, left=0, right=0, subArrayCnt=0, oddCnt=0, prefixEven=0;
        while(right<len) {
            if(nums[right]%2>0)
                oddCnt++;
            while(left<right && (nums[left]%2==0 || oddCnt>k)) {
                if(nums[left]%2==0)
                    prefixEven++;
                else
                    prefixEven=0;
                oddCnt-=nums[left++]%2>0?1:0;
            }
            subArrayCnt+=oddCnt==k?1+prefixEven:0;
            right++;
        }
        return subArrayCnt;
    }
}
