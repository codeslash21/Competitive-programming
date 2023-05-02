// Using dfs
// t.c.=O(n), s.c.=O(n)
class Solution {
    List<Integer> l = new ArrayList<>();
    private void getLeaf(TreeNode root) {
        if(root==null)
            return;
        if(root.left==null && root.right==null){
            l.add(root.val);
            return;
        }
        getLeaf(root.left);
        getLeaf(root.right);
    }
    private boolean checkLeaf(TreeNode root) {
        if(root==null)
            return true;
        if(root.left==null && root.right==null)
            if(l.size()>0 && root.val==l.get(0)) {
                l.remove(0);
                return true;
            }
            else 
                return false;
        return checkLeaf(root.left) && checkLeaf(root.right);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        getLeaf(root1);
        return checkLeaf(root2) && l.size()==0;
    }
}
