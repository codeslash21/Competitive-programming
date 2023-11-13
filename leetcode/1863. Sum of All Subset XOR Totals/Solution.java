// Usinng backtracking
// t.c.=O(2^n), s.c.=O(n)
class Solution {
    public int subsetXORSum(int[] nums) {
        return helper(nums, 0, 0);
    }
    private int helper(int[] nums, int index, int currXor) {
        if(index==nums.length)
            return currXor;
        int with = helper(nums, index+1, currXor^nums[index]);
        int withOut = helper(nums, index+1, currXor);
        return with + withOut;
    }
}
