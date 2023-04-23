// Using preorder iterative approach
// t.c.=O(n), s.c.=O(n)
class Solution {
    private boolean isLeaf(TreeNode node) {
        return node!=null && node.left==null && node.right==null;
    }
    public int sumOfLeftLeaves(TreeNode root) {
        int total=0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if(isLeaf(node.left))
                total+=node.left.val;
            if(node.left!=null)
                queue.add(node.left);
            if(node.right!=null)
                queue.add(node.right);
        }
        return total;
    }
}

// Using recursive preorder approach
// t.c.=O(n), s.c.=O(n)
class Solution {
    private int processSubTree(TreeNode node, boolean isLeft) {
        if(node==null)
            return 0;
        if(node.left==null && node.right==null)
            return isLeft? node.val:0;
        return processSubTree(node.left, true)+processSubTree(node.right, false);
    }
    public int sumOfLeftLeaves(TreeNode root) {
        return processSubTree(root, false);
    }
}

