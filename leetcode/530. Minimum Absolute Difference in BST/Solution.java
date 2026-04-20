// https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int getMinimumDifference(TreeNode root) {
        int minDiff=Integer.MAX_VALUE;
        TreeNode curr=root, prev=null, predecessor=null;
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
