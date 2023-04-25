// Using dfs recursive solution
// t.c.=O(n), s.c.=O(n)
class Solution {
    int max=0;
    private int helper(TreeNode root) {
        if(root==null)
            return 0;
        int left=helper(root.left);
        int right=helper(root.right);
        max=Math.max(max, left+right);
        return Math.max(left, right)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return max;
    }
}
