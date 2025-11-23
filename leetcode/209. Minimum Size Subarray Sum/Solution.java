// https://leetcode.com/problems/minimum-size-subarray-sum/description/
// binary search + sliding window
// t.c.=O(nlogn), s.c.=O(1)
class Solution {
    public boolean windowValid(int[] nums, int windowSize, int target) {
        int len=nums.length, left=0, right=0, sum=0;
        while(right<len) {
            sum+=nums[right];
            if(right>=windowSize)
                sum-=nums[right-windowSize];
            if(sum>=target)
                return true;
            right++;
        }
        return false;
    }
    public int minSubArrayLen(int target, int[] nums) {
        int len=nums.length, left=0, right=len;
        while(left<=right) {
            int mid=left+(right-left)/2;
            if(windowValid(nums, mid, target))
                right=mid-1;
            else
                left=mid+1;
        }
        return left>len?0:left;
    }
}

// sliding window
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len=nums.length, left=0, right=0, sum=0, res=Integer.MAX_VALUE;
        while(right<len) {
            sum+=nums[right++];
            while(left<=right && sum>=target) {
                res=Math.min(res, right-left);
                sum-=nums[left++];
            }
        }
        return res==Integer.MAX_VALUE?0:res;
    }
}
