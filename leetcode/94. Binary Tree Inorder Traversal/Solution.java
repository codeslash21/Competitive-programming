// recursive approach
// t.c.=O(n), s.c.=O(n)
class Solution {
    List<Integer> ans = new ArrayList<>();
    private void helper(TreeNode node) {
        if(node==null)
            return;
        helper(node.left);
        ans.add(node.val);
        helper(node.right);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        helper(root);
        return ans;
    }
}

// using iterative approach
// t.c.=O(n), s.c.=O(n)
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr=root;
        while(curr!=null || !stack.isEmpty()) {
            while(curr!=null) {
                stack.push(curr);
                curr=curr.left;
            }
            curr=stack.pop();
            ans.add(curr.val);
            curr=curr.right;
        }
        return ans;
    }
}
