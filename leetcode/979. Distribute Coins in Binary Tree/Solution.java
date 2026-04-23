// https://leetcode.com/problems/distribute-coins-in-binary-tree/description/
// using postorder
// t.c.=O(n), s.c.=O(n)
class Solution {
    int count=0;
    public int distributeCoins(TreeNode root) {
        helper(root);
        return count;
    }
    private int helper(TreeNode root) {
        if(root==null)  return 0;
        int leftCount=helper(root.left);
        int rightCount=helper(root.right);
        int currCount=root.val-1;
        count=count+Math.abs(leftCount)+Math.abs(rightCount);
        return (leftCount+rightCount+currCount);
    }
}
