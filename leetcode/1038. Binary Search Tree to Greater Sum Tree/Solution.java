// Using array
// t.c.=O(n), s.c.=O(n)
class Solution {
    List<Integer> vals = new ArrayList<>();
    List<TreeNode> nodes = new ArrayList<>();
    private void helper(TreeNode root) {
        if(root==null)
            return;
        helper(root.left);
        vals.add(root.val);
        nodes.add(root);
        helper(root.right);
    }
    public TreeNode bstToGst(TreeNode root) {
        helper(root);
        int i=vals.size();
        for(int j=i-2;j>=0;j--)
            vals.set(j, vals.get(j)+vals.get(j+1));
        for(int j=0;j<i;j++)
            nodes.get(j).val=vals.get(j);
        return root;
    }
}

// Using recursion
// t.c.=O(n), s.c.=O(n)
class Solution {
    int sum=0;
    public TreeNode bstToGst(TreeNode root) {
        if(root==null)
            return root;
        bstToGst(root.right);
        sum+=root.val;
        root.val=sum;
        bstToGst(root.left);
        return root;
    }
}
