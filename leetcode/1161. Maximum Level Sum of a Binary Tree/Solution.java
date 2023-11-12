// using bfs
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int maxLevelSum(TreeNode root) {
        int res=0, level=1, maxSum=Integer.MIN_VALUE;
        if(root==null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            int sum=0;
            while(len-->0) {
                TreeNode curr = queue.poll();
                sum+=curr.val;
                if(curr.left!=null) 
                    queue.offer(curr.left);
                if(curr.right!=null)
                    queue.offer(curr.right);
            }
            if(maxSum<sum) {
                maxSum=sum;
                res=level;
            }
            level++;
        }
        return res;
    }
}
