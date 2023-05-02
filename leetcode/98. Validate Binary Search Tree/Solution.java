// Using iterative inorder traversal
// t.c.=O(n), s.c.=O(n)
class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Integer prev=null;
        while(root!=null || !stack.isEmpty()) {
            while(root!=null) {
                stack.push(root);
                root=root.left;
            }
            root = stack.pop();
            if(prev!=null && root.val<=prev)
                return false;
            prev=root.val;
            root=root.right;
        }
        return true;
    }
}

// Inorder recusrsive
// t.c.=O(n), s.c.=O(n)
class Solution {
    Integer prev=null;
    private boolean inorder(TreeNode root) {
        if(root==null)
            return true;
        if(!inorder(root.left))
            return false;
        if(prev!=null && root.val<=prev)
            return false;
        prev=root.val;
        return inorder(root.right);
    }
    public boolean isValidBST(TreeNode root) {
        return inorder(root);   
    }
}

// Recursion with valid range
// t.c.=O(n), s.c.=O(n)
class Solution {
    private boolean validate(TreeNode root, Integer low, Integer high) {
        if(root==null)
            return true;
        if((low!=null && root.val<=low) || (high!=null && root.val>=high))
            return false;
        return validate(root.left, low, root.val) && validate(root.right, root.val, high);
    }
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);   
    }
}
