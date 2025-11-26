// https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/description/
// sliding window
// t.c.=O(n), s.c.=O(1)
class Solution {
    public long countSubarrays(int[] nums, int k) {
        int len=nums.length, left=0, right=0, cnt=0, max=Arrays.stream(nums).max().getAsInt();
        long res=0;
        while(right<len) {
            if(nums[right]==max)
                cnt++;
            while(cnt>=k) {
                res+=len-right;
                cnt-=nums[left++]==max?1:0;
            }
            right++;
        }
        return res;
    }
}
