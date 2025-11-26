// https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/description/
// sliding window + hashmap
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int len=nums.length, left=0, right=0, maxLen=0;
        Map<Integer, Integer> freq=new HashMap<>();
        while(right<len) {
            int currNum=nums[right];
            freq.put(currNum, freq.getOrDefault(currNum, 0)+1);
            while(freq.get(currNum)>k) {
                int num=nums[left++];
                freq.put(num, freq.getOrDefault(num, 0)-1);
            }
            maxLen=Math.max(maxLen, right+1-left);
            right++;
        }
        return maxLen;
    }
}
