// https://leetcode.com/problems/binary-subarrays-with-sum/description/
// prefix sum
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int ans=0, sum=0;
        Map<Integer, Integer> prefixSum=new HashMap<>();
        for(int num:nums) {
            sum+=num;
            if(sum==goal)
                ans++;
            ans+=prefixSum.getOrDefault(sum-goal, 0);
            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0)+1);
        }
        return ans;
    }
}

// sliding window (one pass)
// t.c.=O(n), s.c.=O(1)
class Solution {
    private int slidingWindowAtMost(int[] nums, int goal) {
        int len=nums.length, left=0, right=0, currSum=0, totalCnt=0;
        while(right<len) {
            currSum+=nums[right];
            while(left<=right && currSum>goal)
                currSum-=nums[left++];
            totalCnt+=(right+++1-left);
        }
        return totalCnt;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return slidingWindowAtMost(nums, goal)-slidingWindowAtMost(nums, goal-1);
    }
}

// sliding window (single pass)
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int len=nums.length, left=0, right=0, currSum=0, prefixZeros=0, cnt=0;
        while(right<len) {
            currSum+=nums[right];
            while(left<right && (nums[left]==0 || currSum>goal)) {
                if(nums[left]==0)
                    prefixZeros++;
                else
                    prefixZeros=0;
                currSum-=nums[left++];
            }
            if(currSum==goal)
                cnt+=1+prefixZeros;
            right++;
        }
        return cnt;
    }
}
