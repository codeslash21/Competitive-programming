// Using bfs
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)
            return 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        Integer maxWidth=0;
        queue.offer(new Pair<>(root, 1));
        while(!queue.isEmpty()) {
            int len=queue.size();
            Pair<TreeNode, Integer> first = queue.peek(), last = null;
            while(len-->0) {
                last = queue.poll();
                TreeNode node = last.getKey();
                if(node.left!=null)
                    queue.offer(new Pair(node.left, 2*last.getValue()));
                if(node.right!=null)
                    queue.offer(new Pair(node.right, 2*last.getValue()+1));
            }
            maxWidth = Math.max(maxWidth, last.getValue() - first.getValue() + 1);
        }
        return maxWidth;
    }
}
