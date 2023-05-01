// Using preorder travversal
// t.c.=O(n), s.c.=O(n)
class Solution {
    List<Integer> left = new ArrayList<>();
    List<Integer> right = new ArrayList<>();
    List<Integer> leaf = new ArrayList<>();
    private boolean isLeaf(TreeNode node) {
        return node.left==null && node.right==null;
    }
    private boolean isRoot(int flag) {
        return flag==0;
    }
    private boolean isLeftBoundary(int flag) {
        return flag==1;
    }
    private boolean isRightBoundary(int flag) {
        return flag==2;
    }
    private int leftChildFlag(TreeNode node, int flag) {
        if(isLeftBoundary(flag)||isRoot(flag))
            return 1;
        else if(isRightBoundary(flag) && node.right==null)
            return 2;
        else
            return 3;
    }
    private int rightChildFlag(TreeNode node, int flag) {
        if(isRightBoundary(flag)||isRoot(flag))
            return 2;
        else if(isLeftBoundary(flag) && node.left==null)
            return 1;
        else
            return 3;
    }
    private void preorder(TreeNode root, int flag) {
        if(root==null)
            return;
        if(isRightBoundary(flag))
            right.add(0, root.val);
        else if(isLeftBoundary(flag) || isRoot(flag))
            left.add(root.val);
        else if(isLeaf(root))
            leaf.add(root.val);
        preorder(root.left, leftChildFlag(root, flag));
        preorder(root.right, rightChildFlag(root, flag));
    }
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        preorder(root, 0);
        left.addAll(leaf);
        left.addAll(right);
        return left;
    }
}
