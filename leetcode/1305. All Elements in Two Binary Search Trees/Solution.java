// Iterative approach
// t.c.=O(n+m), s.c.=O(n+m)
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> stack1 = new Stack<>(), stack2 = new Stack<>();
        List<Integer> output = new ArrayList<>();
        while(root1!=null || root2!=null || !stack1.isEmpty() || !stack2.isEmpty()) {
            while(root1!=null) {
                stack1.push(root1);
                root1=root1.left;
            }
            while(root2!=null) {
                stack2.push(root2);
                root2=root2.left;
            }
            if(stack2.isEmpty() || !stack1.isEmpty() && stack1.peek().val<=stack2.peek().val) {
                root1=stack1.pop();
                output.add(root1.val);
                root1=root1.right;
            }
            else {
                root2=stack2.pop();
                output.add(root2.val);
                root2=root2.right;
            }
        }
        return output;
    }
}

// using recursion
// t.c.=O(n), s.c.=O(n)
class Solution {
    List<Integer> first = new ArrayList<>(), second = new ArrayList<>();
    List<Integer> res = new ArrayList<>();
    private void inorder(TreeNode root, int flag) {
        if(root==null)
            return;
        inorder(root.left, flag);
        if(flag==1)
            first.add(root.val);
        else
            second.add(root.val);
        inorder(root.right, flag);
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        inorder(root1, 1);
        inorder(root2, 2);
        while(first.size()>0 && second.size()>0) {
            if(first.get(0)<=second.get(0)) {
                res.add(first.get(0));
                first.remove(0);
            }
            else {
                res.add(second.get(0));
                second.remove(0);
            }
        }
        if(first.size()>0)
            res.addAll(first);
        if(second.size()>0)
            res.addAll(second);
        return res;
    }
}
