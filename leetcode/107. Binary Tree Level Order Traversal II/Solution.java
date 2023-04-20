// Using recursion DFS
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null)
            return levels;
        helper(root, 0);
        Collections.reverse(levels);
        return levels;
    }
}
