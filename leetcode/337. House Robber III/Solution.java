// https://leetcode.com/problems/house-robber-iii/submissions/2063304849/
// using recursion
// t.c.=O(2^n), s.c.=O(n)
class Solution {
    public int rob(TreeNode root) {
        if(root==null)  return 0;
        int res=root.val;
        if(root.left!=null)
            res+=rob(root.left.left)+rob(root.left.right);
        if(root.right!=null)
            res+=rob(root.right.left)+rob(root.right.right);
        res=Math.max(res, rob(root.right)+rob(root.left));
        return res;
    }
}

// using dp
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int rob(TreeNode root) {
        int[] result=robHelper(root);
        return Math.max(result[0], result[1]);
    }
    // return [robThis, skipThis]
    private int[] robHelper(TreeNode node) {
        if(node==null)  return new int[]{0, 0};
        int[] left=robHelper(node.left);
        int[] right=robHelper(node.right);
        int robThis=node.val+left[1]+right[1];
        int skipThis=Math.max(left[0], left[1])+Math.max(right[0], right[1]);
        return new int[]{robThis, skipThis};
    }
}
