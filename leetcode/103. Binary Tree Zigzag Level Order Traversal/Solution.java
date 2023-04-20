// using BFS
// t.c.=O(n), s.c.=O(n)
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        int level=0;
        if(root==null)
            return ans;
        queue.add(root);
        while(!queue.isEmpty()) {
            ans.add(new ArrayList<>());
            int level_length=queue.size();
            for(int i=0;i<level_length;i++) {
                TreeNode node = queue.remove();
                if(level%2==1)
                    ans.get(level).add(0, node.val);
                else
                    ans.get(level).add(node.val);
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
            level++;
        }
        return ans;
    }
}
