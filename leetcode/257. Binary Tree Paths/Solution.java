// t.c.=O(n), s.c.=O(n)
class Solution {
    List<String> res;
    private void helper(TreeNode root, String path) {
        if(root!=null) {
            path+=Integer.toString(root.val);
            if(root.left==null && root.right==null)
                res.add(path);
            else {
                path+="->";
                helper(root.left, path);
                helper(root.right, path);
            }
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        helper(root, "");
        return res;
    }
}
