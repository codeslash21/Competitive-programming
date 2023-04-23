// Using recursion
// t.c.=O(n), s.c.=O(n)
class Solution {
    int pre_idx=0;
    Map<Integer, Integer> map = new HashMap<>();
    private TreeNode helper(int[] preorder, int[] inorder, int left, int right) {
        if(left>right)
            return null;
        int val = preorder[pre_idx++];
        TreeNode root = new TreeNode(val);
        int idx=map.get(val);
        root.left=helper(preorder, inorder, left, idx-1);
        root.right=helper(preorder, inorder, idx+1, right);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int idx=0;
        for(Integer val:inorder)
            map.put(val, idx++);
        return helper(preorder, inorder, 0, inorder.length-1);
    }
}
