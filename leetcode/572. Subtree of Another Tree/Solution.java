// using dfs
// t.c.=O(m*n), s.c.=O(m+n), where m=#nodes in first tree, n=#nodes in substree
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null)
            return false;
        if(isIdentical(root, subRoot))
            return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    public boolean isIdentical(TreeNode node1, TreeNode node2) {
        if(node1==null || node2==null)
            return node1==null && node2==null;
        return node1.val==node2.val && isIdentical(node1.left, node2.left) && isIdentical(node1.right, node2.right);
    }
}
