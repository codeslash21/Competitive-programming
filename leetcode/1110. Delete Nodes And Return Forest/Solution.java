// https://leetcode.com/problems/delete-nodes-and-return-forest/description/
// postorder traversal
// t.c.=O(n), s.c.=O(n)
class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> roots=new ArrayList<>();
        Set<Integer> valuesToDelete=new HashSet<>();
        for(int value:to_delete)
            valuesToDelete.add(value);
        dfs(root, true, valuesToDelete, roots);
        return roots;
    }
    private TreeNode dfs(TreeNode node, boolean isRoot, Set<Integer> valuesToDelete, List<TreeNode> roots) {
        if(node==null)
            return null;
        boolean shouldDelete=valuesToDelete.contains(node.val);
        node.left=dfs(node.left, shouldDelete, valuesToDelete, roots);
        node.right=dfs(node.right, shouldDelete, valuesToDelete, roots);
        if(isRoot && !shouldDelete)
            roots.add(node);
        return shouldDelete? null:node;
    }
}
