// Using recursion
// t.c.=O(n), s.c.=O(n)
class Solution {
    TreeNode ans;
    private boolean recurseTree(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return false;
        int left=recurseTree(root.left, p, q)? 1:0;
        int right=recurseTree(root.right, p, q)? 1:0;
        int mid=(root==p || root==q)? 1:0;
        if(mid+left+right==2)
            ans=root;
        return mid+left+right>0;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recurseTree(root, p, q);
        return ans;
    }
}

// Using parent pointer
// t.c.=O(n), s.c.=O(n)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> queue= new ArrayDeque<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);
        queue.add(root);
        while(!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = queue.remove();
            if(node.left!=null) {
                parent.put(node.left, node);
                queue.add(node.left);
            }
            if(node.right!=null) {
                parent.put(node.right, node);
                queue.add(node.right);
            }
        }
        Set<TreeNode> set = new HashSet<>();
        while(p!=null) {
            set.add(p);
            p=parent.get(p);
        }
        while(!set.contains(q))
            q=parent.get(q);
        return q;
    }
}

