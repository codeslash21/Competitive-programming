// Using recursion
// t.c.=O(n), s.c.=O(n)
class Solution {
    int sum=0;
    int low, high;
    private void helper(TreeNode root) {
        if(root==null)
            return;
        if(root.val>=low && root.val<=high) 
            sum+=root.val;
        if(root.val<high)
            helper(root.right);
        if(root.val>low)
            helper(root.left);
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        this.low=low;
        this.high=high;
        helper(root);
        return sum;
    }
}
