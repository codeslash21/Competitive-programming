// t.c.=O(n), s.c.=O(n)
class Solution {
    int min1;
    long ans = Long.MAX_VALUE;
    private void dfs(TreeNode root) {
        if(root!=null) {
            if(min1<root.val && root.val<ans)
                ans=root.val;
            else {
                dfs(root.left);
                dfs(root.right);
            }
        }
    }
    public int findSecondMinimumValue(TreeNode root) {
        min1=root.val;
        dfs(root);
        return ans<Long.MAX_VALUE? (int)ans:-1;
    }
}
