// Using recursion
// t.c.=O(4^n/n^(1/2)), s.c.=O(4^n/n^(1/2))
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> helper(int start, int end) {
        List<TreeNode> trees = new ArrayList<>();
        if(start>end) {
            trees.add(null);
            return trees;
        }
        for(int i=start; i<=end; i++) {
            List<TreeNode> left_tree = helper(start, i-1);
            List<TreeNode> right_tree = helper(i+1, end);
            for(TreeNode l : left_tree) 
                for(TreeNode r : right_tree) {
                    TreeNode root = new TreeNode(i);
                    root.left=l;
                    root.right=r;
                    trees.add(root);
                }
        }
        return trees;
    }
    public List<TreeNode> generateTrees(int n) {
        if(n==0)
            return new ArrayList<TreeNode>();
        return helper(1, n);
    }
}
