// https://leetcode.com/problems/path-sum-ii/description/
// t.c.=O(n^2), s.c.=O(n)
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result=new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), result);
        return result;
    }
    private void dfs(TreeNode node, int remainingSum, List<Integer> path, List<List<Integer>> result) {
        if(node==null)  return;
        path.add(node.val);
        remainingSum-=node.val;
        if(node.left==null && node.right==null && remainingSum==0)
            result.add(new ArrayList<>(path));
        else {
            dfs(node.left, remainingSum, path, result);
            dfs(node.right, remainingSum, path, result);
        }
        path.remove(path.size()-1);
    }
}
