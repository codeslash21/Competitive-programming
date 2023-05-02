// Using recursion
// t.c.=O(n), s.c.=O(n)
class Solution {
    private TreeNode helper(TreeNode root, int low, int high) {
        if(root==null)
            return null;
        if(root.val>high)
            return helper(root.left, low, high);
        if(root.val<low)
            return helper(root.right, low, high);
        root.left = helper(root.left, low, high);
        root.right = helper(root.right, low, high);
        return root;
    }
    public TreeNode trimBST(TreeNode root, int low, int high) {
        return helper(root, low, high);
    }
}
