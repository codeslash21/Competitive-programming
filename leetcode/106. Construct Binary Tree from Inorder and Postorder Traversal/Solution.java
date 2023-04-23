// Using recursion
// t.c.=O(n), s.c.=O(n)
class Solution {
    int post_idx;
    Map<Integer, Integer> map = new HashMap<>();
    private TreeNode helper(int[] inorder, int[] postorder, int left, int right) {
        if(left>right)
            return null;
        int val = postorder[post_idx];
        post_idx--;
        TreeNode root = new TreeNode(val);
        int index = map.get(val);
        root.right=helper(inorder, postorder, index+1, right);
        root.left=helper(inorder, postorder, left, index-1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        post_idx=inorder.length-1;
        int idx=0;
        for(Integer val:inorder)
            map.put(val, idx++);
        return helper(inorder, postorder, 0, inorder.length-1);
    }
}
