// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
// reverse pre-order
// t.c.=O(n), s.c.=O(h)
class Solution {
    TreeNode prev=null;
    public void flatten(TreeNode root) {
        if(root==null)  return;
        flatten(root.right);
        flatten(root.left);
        root.right=prev;
        root.left=null;
        prev=root;
    }
}

// using Morris traversal algorithm
// t.c.=O(n), s.c.=O(1)
class Solution {
    public void flatten(TreeNode root) {
        TreeNode curr=root;
        while(curr!=null) {
            if(curr.left!=null) {
                TreeNode predecessor=curr.left;
                while(predecessor.right!=null)
                    predecessor=predecessor.right;
                predecessor.right=curr.right;
                curr.right=curr.left;
                curr.left=null;
            }
            curr=curr.right;
        }
    }
}
