// https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/
// t.c.=O(1), s.c.=O(1)
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
    public int minDiffInBST(TreeNode root) {
        int minDiff=Integer.MAX_VALUE;
        TreeNode curr=root, prev=null, predecessor=null;
        if(root==null)  return 0;
        while(curr!=null) {
            if(curr.left==null) {
                if(prev!=null)
                    minDiff=Math.min(minDiff, curr.val-prev.val);
                prev=curr;
                curr=curr.right;
            } else {
                predecessor=curr.left;
                while(predecessor.right!=null && predecessor.right!=curr)
                    predecessor=predecessor.right;
                if(predecessor.right==null) {
                    predecessor.right=curr;
                    curr=curr.left;
                } else {
                    predecessor.right=null;
                    minDiff=Math.min(minDiff, curr.val-prev.val);
                    prev=curr;
                    curr=curr.right;
                }
            }
        }
        return minDiff;
    }
}
