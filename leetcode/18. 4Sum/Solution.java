// Using two pointer technique
// t.c.=O(n^3), s.c.=O(k) for recursion, in general it can be O(n) in worst case
class Solution {
    public List<List<Integer>> twoSum(int[] nums, int start, int end, long target) {
        List<List<Integer>> res = new ArrayList<>();
        while(start<end) {
            long val = nums[start]+nums[end];
            if(val<target)
                start++;
            else if(val>target)
                end--;
            else {
                res.add(Arrays.asList(nums[start++], nums[end--]));
                while(start<end && nums[start]==nums[start-1])
                    start++;
            }
        }
        return res;
    }
    public List<List<Integer>> kSum(int[] nums, int start, long target, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int n=nums.length;
        if(start==n) 
            return res;
        long avg_value = target/k;
        if(avg_value<nums[start] || nums[n-1]<avg_value)
            return res;
        if(k==2)
            return twoSum(nums, start, n-1, target);
        for(int i=start;i<n;i++) {
            if(i==start || nums[i-1]!=nums[i])
                for(List<Integer> subset:kSum(nums, i+1, target-nums[i], k-1)) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size()-1).addAll(subset);
                }
        }
        return res;
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, 0, target, 4);
    }
}

// Using hashset
// t.c.=O(n^3), s.c.=O(n) for hashset
class Solution {
    public List<List<Integer>> twoSum(int[] nums, int start, int end, long target) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Long> s = new HashSet<>();
        for(int i=start;i<=end;i++) {
            if(res.isEmpty() || nums[i-1] != nums[i]) 
                if(s.contains(target-nums[i]))
                    res.add(Arrays.asList((int)target-nums[i], nums[i]));
            s.add((long)nums[i]);
        }
        return res;
    }
    public List<List<Integer>> kSum(int[] nums, int start, long target, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int n=nums.length;
        if(start==n) 
            return res;
        long avg_value = target/k;
        if(avg_value<nums[start] || nums[n-1]<avg_value)
            return res;
        if(k==2)
            return twoSum(nums, start, n-1, target);
        for(int i=start;i<n;i++) {
            if(i==start || nums[i-1]!=nums[i])
                for(List<Integer> subset:kSum(nums, i+1, target-nums[i], k-1)) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size()-1).addAll(subset);
                }
        }
        return res;
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, 0, target, 4);
    }
}
