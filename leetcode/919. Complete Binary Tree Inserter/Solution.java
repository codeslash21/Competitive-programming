// using queue
// t.c.=O(n), s.c.=O(n)
class CBTInserter {
    TreeNode treeRoot=null;
    Queue<TreeNode> queue = new LinkedList<>();
    public CBTInserter(TreeNode root) {
        treeRoot=root;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            if(curr.left==null || curr.right==null)
                queue.offer(curr);
            if(curr.left!=null)
                q.offer(curr.left);
            if(curr.right!=null)
                q.offer(curr.right);
        }
    }
    
    public int insert(int val) {
        TreeNode curr = queue.peek(), node = new TreeNode(val);
        if(curr.left==null)
            curr.left=node;
        else {
            curr.right=node;
            queue.poll();
        }
        queue.offer(node);
        return curr.val;
    }
    
    public TreeNode get_root() {
        return treeRoot;
    }
}
