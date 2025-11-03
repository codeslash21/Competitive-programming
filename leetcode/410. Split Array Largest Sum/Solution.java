// https://leetcode.com/problems/split-array-largest-sum/description/
// binary search
// t.c.=O(NlogC), s.c.=O(1), N=len(nums), C=sum(nums)
class Solution {
    public int getNumberOfPossibleSubArrays(int[] nums, int targetSum) {
        int count=1, len=nums.length, sum=0;
        for(int num:nums) {
            sum+=num;
            if(sum>targetSum) {
                count++;
                sum=num;
            }
        }
        return count;
    }
    public int splitArray(int[] nums, int k) {
        int len=nums.length, left=0, right=0;
        for(int num:nums) {
            left=Math.max(left, num);
            right+=num;
        }
        while(left<=right) {
            int mid=left+(right-left)/2;
            int possibleSubArrays=getNumberOfPossibleSubArrays(nums, mid);
            if(possibleSubArrays>k)
                left=mid+1;
            else
                right=mid-1;
        }
        return left;
    }
}
