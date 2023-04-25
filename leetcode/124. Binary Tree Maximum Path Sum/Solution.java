// Using recursion
// t.c.=O(n), s.c.=O(n)
class Solution {
    int max=Integer.MIN_VALUE;
    private int helper(TreeNode root) {
        if(root==null)
            return 0;
        int gainFromLeft=Math.max(helper(root.left), 0);
        int gainFromRight=Math.max(helper(root.right), 0);
        max = Math.max(max, gainFromLeft+gainFromRight+root.val);
        return Math.max(gainFromLeft+root.val, gainFromRight+root.val);
    }
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }
}
