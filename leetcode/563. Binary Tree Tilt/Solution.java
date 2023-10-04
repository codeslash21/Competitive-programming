// using recursion
// t.c.=O(n), s.c.=O(n)
class Solution {
    int res=0;
    private int helper(TreeNode root) {
        if(root==null)
            return 0;
        int left=helper(root.left), right=helper(root.right);
        int sum=root.val+left+right, diff=Math.abs(left-right);
        root.val=diff;
        res+=diff;
        return sum;
    }
    public int findTilt(TreeNode root) {
        helper(root);
        return res;
    }
}
