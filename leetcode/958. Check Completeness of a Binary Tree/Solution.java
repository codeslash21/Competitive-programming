// using bfs
// t.c.=O(n), s.c.=O(n)
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        boolean found = false;
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node==null)
                found=true;
            else {
                if(found)
                    return false;
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return true;
    }
}
