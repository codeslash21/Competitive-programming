// https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/
class Solution {
    int count=0;
    public int goodNodes(TreeNode root) {
        helper(root, new ArrayList<>());
        return count;
    }
    private void helper(TreeNode node, List<Integer> curr) {
        if(node==null)  return;
        int size=curr.size();
        boolean isGood=true;
        for(int i=0;i<size;i++)
            if(curr.get(i)>node.val) {
                isGood=false;
                break;
            }
        count+=isGood?1:0;
        curr.add(node.val);
        helper(node.left, curr);
        helper(node.right, curr);
        curr.remove(curr.size()-1);
    }
}
