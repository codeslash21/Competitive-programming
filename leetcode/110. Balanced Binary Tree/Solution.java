// Using recursion
// t.c.=O(n), s.c.=O(n)
class Solution {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root)!=-1;
    }
    public int getHeight(TreeNode node) {
        if(node==null)
            return 0;
        int l=getHeight(node.left), r=getHeight(node.right);
        if(l==-1 || r==-1 || Math.abs(l-r)>1)
            return -1;
        return Math.max(l,r)+1;
    }
}
