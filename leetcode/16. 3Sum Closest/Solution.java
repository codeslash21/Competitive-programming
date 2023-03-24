// Using two pointer
// t.c.=O(n^2), s.c.=O(1)
class Solution {
    public int twoSum(int[] nums, int start, int end, int target, int diff) {
        while(start<end) {
            int sum=nums[start]+nums[end];
            if(Math.abs(target-sum)<Math.abs(diff))
                diff=target-sum;
            if(sum<target)
                start++;
            else
                end--;
        }
        return diff;
    }
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int diff = Integer.MAX_VALUE;
        for(int i=0;i<n-2;i++) 
            diff=Math.min(Math.abs(diff), twoSum(nums, i+1, n-1, target-nums[i], diff));
        return target-diff;
    }
}

// Using binary Search
// t.c.=O(n^2logn) s.c.=O(1)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int sz = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < sz && diff != 0; ++i) {
            for (int j = i + 1; j < sz - 1; ++j) {
                int complement = target - nums[i] - nums[j];
                var idx = Arrays.binarySearch(nums, j + 1, sz - 1, complement);
                int hi = idx >= 0 ? idx : ~idx, lo = hi - 1;
                if (hi < sz && Math.abs(complement - nums[hi]) < Math.abs(diff))
                    diff = complement - nums[hi];
                if (lo > j && Math.abs(complement - nums[lo]) < Math.abs(diff))
                    diff = complement - nums[lo];
            }
        }
        return target - diff;
    }
}
