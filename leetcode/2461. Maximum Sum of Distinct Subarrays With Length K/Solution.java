// https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/
// sliding window
// t.c.=O(n), s.c.=O(n)
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int len=nums.length, left=0, right=0;
        long maxSum=0, currSum=0;
        Map<Integer, Integer> numToIdx=new HashMap<>();
        while(right<len) {
            int currNum=nums[right];
            int lastOccurrence=numToIdx.getOrDefault(currNum, -1);
            while(left<=lastOccurrence || right+1-left>k) 
                currSum-=nums[left++];
            numToIdx.put(currNum, right);
            currSum+=currNum;
            if(right+1-left==k)
                maxSum=Math.max(maxSum, currSum);
            right++;
        }
        return maxSum;
    }
}
