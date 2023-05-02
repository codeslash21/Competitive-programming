// Using recursion
// t.c.=O(n^2), s.c.=O(n)
class Solution {
    private int findMax(int[] nums, int start, int end) {
        int max=start;
        for(int i=start+1;i<=end;i++) 
            if(nums[i]>nums[max])
                max=i;
        return max;
    }
    private TreeNode helper(int[] nums, int start, int end) {
        if(start>end)
            return null;
        int idx = findMax(nums, start, end);
        TreeNode root = new TreeNode(nums[idx]);
        root.left = helper(nums, start, idx-1);
        root.right = helper(nums, idx+1, end);
        return root;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
}
