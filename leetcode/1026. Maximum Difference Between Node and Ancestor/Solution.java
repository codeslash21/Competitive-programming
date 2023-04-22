// Recursion
// t.c.=O(n), s.c.=O(n)
class Solution {
    int maxVal=0;
    public int maxAncestorDiff(TreeNode root) {
        helper(root, root.val, root.val);
        return maxVal;
    }
    private void helper(TreeNode root, int max, int min) {
        if(root==null)
            return;
        int currVal = Math.max(Math.abs(root.val-max), Math.abs(root.val-min));
        maxVal = Math.max(maxVal, currVal);
        max=Math.max(max, root.val);
        min=Math.min(min, root.val);
        helper(root.left, max, min);
        helper(root.right, max, min);
    }
}

// using max - min
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int maxAncestorDiff(TreeNode root) {
        return helper(root, root.val, root.val);
    }
    private int helper(TreeNode root, int max, int min) {
        if(root==null)
            return max-min;
        max=Math.max(max, root.val);
        min=Math.min(min, root.val);
        int left = helper(root.left, max, min);
        int right = helper(root.right, max, min);
        return Math.max(left, right);
    }
}
