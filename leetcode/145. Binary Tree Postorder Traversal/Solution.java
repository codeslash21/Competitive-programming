// using recursion
// t.c.=O(n), s.c.=O(n)
class Solution {
    List<Integer> res = new ArrayList<>();
    public void helper(TreeNode root) {
        if(root==null)
            return;
        helper(root.left);
        helper(root.right);
        res.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        helper(root);
        return res;
    }
}

// Using iterative approach
// t.c.=O(n), s.c.=O(n)
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if(curr!=null) {
                res.addFirst(curr.val);
                stack.push(curr.left);
                stack.push(curr.right);
            }
        }
        return res;
    }
}
