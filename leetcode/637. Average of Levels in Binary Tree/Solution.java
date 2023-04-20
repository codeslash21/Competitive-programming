// Using bfs
// t.c.=O(n), s.c.==O(n)
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        double sum=0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            sum=0;
            int level_length=queue.size();
            for(int i=0;i<level_length;i++) {
                TreeNode node = queue.remove();
                sum+=node.val;
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
            ans.add(sum/level_length);
        }
        return ans;
    }
}
