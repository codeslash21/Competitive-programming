// Using recursive bfs
// t.c.=O(n), s.c.=O(n)
class Solution {
    int sum=0;
    private void helper(TreeNode root, int num) {
        if(root==null)
            return;
        num=(num*10)+root.val;
        if(root.left==null && root.right==null) 
            sum+=num;
        helper(root.left, num);
        helper(root.right, num);
    }
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }
}
