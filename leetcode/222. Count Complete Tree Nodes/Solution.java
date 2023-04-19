// using recursion
// t.c.=O(n), s.c.=O(d), d is the depth of the tree
class Solution {
    public int countNodes(TreeNode root) {
        if(root==null)
            return 0;
        return 1+countNodes(root.left)+countNodes(root.right);
    }
}

// Using binary search
// t.c.=O(d^2), s.c.=O(1)
class Solution {
    private int calculateDepth(TreeNode root) {
        int d=0;
        while(root.left!=null) {
            d++;
            root=root.left;
        }
        return d;
    }
    private boolean exists(int idx, int d, TreeNode root) {
        int left=0, right=(int)Math.pow(2,d)-1;
        for(int i=0;i<d;i++) {
            int pivot=(left+right)/2;
            if(idx<=pivot) {
                root=root.left;
                right=pivot;
            }
            else {
                root=root.right;
                left=pivot+1;
            }
        }
        return root!=null;
    }
    public int countNodes(TreeNode root) {
        if(root==null)
            return 0;
        int d = calculateDepth(root);
        if(d==0)
            return 1;
        int left=0, right=(int)Math.pow(2,d)-1;
        while(left<=right) {
            int pivot=(left+right)/2;
            if(exists(pivot, d, root))
                left=pivot+1;
            else
                right=pivot-1;
        }
        return (int)Math.pow(2,d)-1+left;
    }
}
