// Using bfs
// t.c.=O(n), s.c.=O(n)
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        if(root!=null)
            queue.add(root);
        while(!queue.isEmpty()) {
            l.add(queue.getLast().val);
            int len = queue.size();
            for(int i=0;i<len;i++) {
                TreeNode node = queue.remove();
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
        }
        return l;
    }
}

// Using bfs
// t.c.=O(n), s.c.=(n)
class Solution {
    List<Integer> l = new ArrayList<>();
    private void helper(TreeNode root, int level) {
        if(l.size()==level)
            l.add(root.val);
        if(root.right!=null)
            helper(root.right, level+1);
        if(root.left!=null)
            helper(root.left, level+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null)
            return l;
        helper(root, 0);
        return l;
    }
}
