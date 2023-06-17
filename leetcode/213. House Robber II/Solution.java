// Using dp iterative approach
// t.c.=O(n), s.c.=O(1)
class Solution {
    int robHelper(int[] nums, int start, int end) {
        int prev=0, secondPrev=0;
        for(int i=start;i<=end;i++) {
            int val=Math.max(nums[i]+secondPrev, prev);
            secondPrev=prev;
            prev=val;
        }
        return prev;
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1)
            return nums[n-1];
        int first = robHelper(nums, 0, n-2);
        int second = robHelper(nums, 1, n-1);
        return Math.max(first, second);
    }
}
