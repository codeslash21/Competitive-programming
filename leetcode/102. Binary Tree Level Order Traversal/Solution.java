// using iterative aapproach
// t.c.=O(n), s.c.=O(n)
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int level=0;
        if(root==null)
            return res;
        queue.add(root);
        while(!queue.isEmpty()) {
            res.add(new ArrayList<Integer>());
            int level_length=queue.size();
            for(int i=0;i<level_length;i++) {
                TreeNode node = queue.remove();
                res.get(level).add(node.val);
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
            level++;
        }
        return res;
    }
}

// Using recursion
// t.c.=O(n), s.c.=O(n)
class Solution {
    private List<List<Integer>> levels = new ArrayList<>();
    private void helper(TreeNode root, int level) {
        if(levels.size()==level) 
            levels.add(new ArrayList<>());
        levels.get(level).add(root.val);
        if(root.left!=null)
            helper(root.left, level+1);
        if(root.right!=null)
            helper(root.right, level+1);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)
            return levels;
        helper(root, 0);
        return levels;
    }
}
