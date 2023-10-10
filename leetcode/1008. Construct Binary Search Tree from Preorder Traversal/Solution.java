// Using inorder and perorder
// t.c.=O(nlogn), s.c.=O(n)
class Solution {
    int pre_idx=0;
    int[] preorder;
    Map<Integer, Integer> map = new HashMap<>();
    private TreeNode helper(int left, int right) {
        if(left==right)
            return null;
        TreeNode root = new TreeNode(preorder[pre_idx]);
        int index = map.get(preorder[pre_idx]);
        pre_idx++;
        root.left=helper(left, index);
        root.right=helper(index+1, right);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        this.preorder=preorder;
        int[] inorder = Arrays.copyOf(preorder, preorder.length);
        Arrays.sort(inorder);
        for(int i=0;i<preorder.length;i++)
            map.put(inorder[i], i);
        return helper(0, inorder.length);
    }
}

// Using recursion
// t.c.=O(n), s.c.=O(n)
class Solution {
    int n, idx=0;
    int[] preorder;
    private TreeNode helper(int min, int max) {
        if(idx==n)
            return null;
        int val=preorder[idx];
        if(val<min || val>max)
            return null;
        TreeNode root = new TreeNode(val);
        idx++;
        root.left=helper(min, val-1);
        root.right=helper(val+1, max);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        this.preorder=preorder;
        this.n=preorder.length;
        return helper(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
