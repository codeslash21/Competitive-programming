// Using recursion
// t.c.=O(n), s.c.=O(n)
class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null)
            return list;
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return list;
    }
}

// Using iteration
// t.c.=O(n), s.c.=O(1)
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if(curr!=null) {
                list.add(curr.val);
                stack.push(curr.right);
                stack.push(curr.left);
            }
        }
        return list;
    }
}
