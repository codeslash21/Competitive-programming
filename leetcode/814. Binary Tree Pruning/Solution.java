// Using recursion
// t.c.=O(n), s.c.=O(n)
class Solution {
    private boolean helper(TreeNode root) {
        if(root==null)
            return false;
        boolean left = helper(root.left);
        boolean right = helper(root.right);
        if(!left)
            root.left=null;
        if(!right)
            root.right=null;
        return root.val==1 || left || right;
    }
    public TreeNode pruneTree(TreeNode root) {
        return helper(root)?root:null;
    }
}
