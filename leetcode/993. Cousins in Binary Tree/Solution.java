// Using dfs
// t.c.=O(n), s.c.=O(n) if tree is skewed
class Solution {
    int recordDepth=-1;
    boolean isCousin=false;
    private boolean helper(TreeNode root, int x, int y, int d) {
        if(root==null)
            return false;
        if(root.val==x || root.val==y) {
            if(recordDepth==-1)
                recordDepth=d;
            return recordDepth==d;
        }
        boolean left=helper(root.left, x, y, d+1);
        boolean right=helper(root.right, x, y, d+1);
        if(left && right && recordDepth!=d+1)
            isCousin=true;
        return left||right;
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        helper(root, x, y, 0);
        return isCousin;
    }
}
