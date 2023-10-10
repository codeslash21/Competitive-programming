// using recursion
// t.c.=O(n), s.c.=O(n)
class Solution {
    TreeNode curr;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        curr=ans;
        inorder(root);
        return ans.right;
    }
    private void inorder(TreeNode root) {
        if(root==null)
            return;
        inorder(root.left);
        root.left=null;
        curr.right=root;
        curr=curr.right;
        inorder(root.right);
    }
}
