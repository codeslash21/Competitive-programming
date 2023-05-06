// Using inorder traversal
// t.c.=O(H+k), s.c.=O(H)
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr=root;
        while(curr!=null || !stack.isEmpty()) {
            while(curr!=null) {
                stack.add(curr);
                curr=curr.left;
            }
            curr=stack.pop();
            k--;
            if(k==0)
                break;
            curr=curr.right;
        }
        return curr.val;
    }
}
