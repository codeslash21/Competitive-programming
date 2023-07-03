// Using recursion
// t.c.=O(n), s.c.=O(h)
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }
    public boolean isMirror(TreeNode first, TreeNode second) {
        if(first==null && second==null)
            return true;
        if(first==null || second==null)
            return false;
        return (first.val==second.val) && isMirror(first.left, second.right) && isMirror(first.right, second.left);
    }
}

// using iterative approach
// t.c.=O(n), s.c.=O(n)
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode t1=queue.poll();
            TreeNode t2=queue.poll();
            if(t1==null && t2==null)
                continue;
            if(t1==null || t2==null)
                return false;
            if(t1.val!=t2.val)
                return false;
            queue.offer(t1.left);
            queue.offer(t2.right);
            queue.offer(t1.right);
            queue.offer(t2.left);
        }
        return true;
    }
}

