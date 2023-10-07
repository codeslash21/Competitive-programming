// Using recursion
// t.c.=O(n), s.c.=O(n)
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null)
            return new TreeNode(val);
        if(root.val<val) 
            root.right=insertIntoBST(root.right, val);
        else
            root.left = insertIntoBST(root.left, val);
        return root;
    }
}

// usinng iteration
// t.c.=O(1), s.c.=O(n)
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = root;
        while(node!=null) {
            if(node.val<val) {
                if(node.right==null) {
                    node.right=new TreeNode(val);
                    return root;
                }
                node=node.right;
            }
            else {
                if(node.left==null) {
                    node.left=new TreeNode(val);
                    return root;
                }
                node=node.left;
            }
        }
        return new TreeNode(val);
    }
}
