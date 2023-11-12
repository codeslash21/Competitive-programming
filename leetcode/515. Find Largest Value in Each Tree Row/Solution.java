// using bfs
// t.c.=O9n), s.c.=O(n)
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null)
            return res;
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int len=queue.size();
            while(len-->0) {
                TreeNode curr = queue.poll();
                if(res.size()<=level)
                    res.add(curr.val);
                res.set(level, Math.max(curr.val, res.get(level)));
                if(curr.left!=null)
                    queue.offer(curr.left);
                if(curr.right!=null)
                    queue.offer(curr.right);
            }
            level++;
        }
        return res;
    }
}
