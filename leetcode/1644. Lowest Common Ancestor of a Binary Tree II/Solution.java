// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii/description/
// using iterative approach
// t.c.=O(n), s.c.=O(n)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr=p;
        Map<TreeNode, TreeNode> parents=new HashMap<>();
        Queue<TreeNode> queue=new LinkedList<>();
        Set<TreeNode> ancestors=new HashSet<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode node=queue.poll();
            if(node.left!=null) {
                parents.put(node.left, node);
                queue.offer(node.left);
            }
            if(node.right!=null) {
                parents.put(node.right, node);
                queue.offer(node.right);
            }
        }
        while(curr!=null) {
            ancestors.add(curr);
            curr=parents.getOrDefault(curr, null);
        }
        curr=q;
        while(curr!=null && !ancestors.contains(curr))
            curr=parents.getOrDefault(curr, null);
        return curr;
    }
}
