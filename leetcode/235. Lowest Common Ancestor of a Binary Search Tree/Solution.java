// Using recursion
// t.c.=O(n), s.c.=O(n)
class Solution {
    private TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val<root.val && q.val<root.val)
            return lca(root.left, p, q);
        else if(p.val>root.val && q.val>root.val)
            return lca(root.right, p, q);
        else 
            return root;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lca(root, p, q);
    }
}

// Using iterative approach
// t..c=O(n), s.c.=O(1)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root!=null) {
            if(p.val<root.val && q.val<root.val)
                root=root.left;
            else if(p.val>root.val && q.val>root.val)
                root = root.right;
            else 
                return root;
        }
        return null;
    }
}
