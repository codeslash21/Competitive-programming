// https://leetcode.com/problems/combination-sum-iv/description/
// using recursion
// t.c.=O(n^t), s.c.=O(t), t=target
class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        return dfs(nums, target);
    }
    private int dfs(int[] nums, int target) {
        if(target==0)   return 1;
        int res=0;
        for(int num:nums) {
            if(target<num)   break;
            res+=dfs(nums, target-num);
        }
        return res;
    }
}

// using dp
// t.c.=O(n*t), s.c.=O(t)
class Solution {
    public int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> dp=new HashMap<>();
        Arrays.sort(nums);
        dp.put(0, 1);
        for(int total=1;total<=target;total++) {
            dp.put(total, 0);
            for(int num:nums) {
                if(num>total)  break;
                dp.put(total, dp.get(total)+dp.getOrDefault(total-num, 0));
            }
        }
        return dp.get(target);
    }
}
