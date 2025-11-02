// https://leetcode.com/problems/count-the-number-of-fair-pairs/description/
// sorting + binary search
// t.c.=O(nlogn), s.c.=O(logn)
class Solution {
    public int findLowerBound(int[] nums, int left, int right, int target) {
        while(left<=right) {
            int mid=left+(right-left)/2;
            if(nums[mid]>=target)
                right=mid-1;
            else
                left=mid+1;
        }
        return left;
    }
    public long countFairPairs(int[] nums, int lower, int upper) {
        int len=nums.length;
        long ans=0;
        Arrays.sort(nums);
        for(int i=0;i<len;i++) {
            int low=findLowerBound(nums, i+1, len-1, lower-nums[i]);
            int high=findLowerBound(nums, i+1, len-1, upper-nums[i]+1);
            ans+=high-low;
        }
        return ans;
    }
}

// sorting + two pointers
// t.c.=O(nlogn), s.c.=O(logn)
class Solution {
    public long totalWindowSize(int[] nums, int target) {
        int left=0, right=nums.length-1;
        long totalWindowSize=0;
        while(left<right) {
            int sum=nums[left]+nums[right];
            if(sum<target) {
                totalWindowSize+=right-left;
                left++;
            } else
                right--;
        }
        return totalWindowSize;
    }
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return totalWindowSize(nums, upper+1)-totalWindowSize(nums, lower);
    }
}
