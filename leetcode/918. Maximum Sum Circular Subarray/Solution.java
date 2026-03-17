// https://leetcode.com/problems/maximum-sum-circular-subarray/description/
// using prefix and suffix sum
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int len=nums.length, suffixSum=nums[len-1];
        int[] rightMax=new int[len];
        rightMax[len-1]=nums[len-1];
        for(int i=len-2;i>=0;i--) {
            suffixSum+=nums[i];
            rightMax[i]=Math.max(rightMax[i+1], suffixSum);
        }
        int currMaxSum=0, normalSum=nums[0], specialSum=nums[0], prefixSum=0;
        for(int i=0;i<len;i++) {
            currMaxSum=Math.max(currMaxSum, 0)+nums[i];
            normalSum=Math.max(normalSum, currMaxSum);
            prefixSum+=nums[i];
            if(i<(len-1))
                specialSum=Math.max(specialSum, prefixSum + rightMax[i+1]);
        }
        return Math.max(normalSum, specialSum);
    }
}

// using Kadane's algo
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum=0, normalSum=nums[0], currMaxSum=0, currMinSum=0, minSum=nums[0];
        for(int num:nums) {
            currMaxSum=Math.max(currMaxSum, 0)+num;
            normalSum=Math.max(normalSum, currMaxSum);
            currMinSum=Math.min(currMinSum, 0)+num;
            minSum=Math.min(minSum, currMinSum);
            totalSum+=num;
        }
        if(totalSum==minSum)
            return normalSum;
        return Math.max(normalSum, totalSum-minSum);
    }
}
