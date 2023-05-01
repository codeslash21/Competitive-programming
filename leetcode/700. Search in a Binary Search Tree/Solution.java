// Using recursion
// t.c.=O(n), s.c.=O(n)
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null || root.val==val)
            return root;
        return root.val>val?searchBST(root.left, val):searchBST(root.right, val);
    }
}

// Using iteration
// t.c.=O(n), s.c.=O(1)
class Solution {
  public TreeNode searchBST(TreeNode root, int val) {
    while (root != null && val != root.val)
      root = val < root.val ? root.left : root.right;
    return root;
  }
}
