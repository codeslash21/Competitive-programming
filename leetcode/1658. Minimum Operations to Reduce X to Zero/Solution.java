// https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/description/
// sliding window
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int minOperations(int[] nums, int x) {
        int len=nums.length, left=0, right=0, currSum=0, sum=0, maxSize=-1;
        for(int num:nums)
            sum+=num;
        sum-=x;
        while(right<len) {
            currSum+=nums[right];
            while(left<=right && currSum>sum)
                currSum-=nums[left++];
            if(currSum==sum)
                maxSize=Math.max(maxSize, right+1-left);
            right++;
        }
        return maxSize<0? maxSize:len-maxSize;
    }
}
