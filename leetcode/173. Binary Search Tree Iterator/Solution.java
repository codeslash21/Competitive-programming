// https://leetcode.com/problems/binary-search-tree-iterator/description/
// t.c.=O(1), s.c.=O(n)
class BSTIterator {
    Stack<TreeNode> stack;
    TreeNode curr;
    public BSTIterator(TreeNode root) {
        stack=new Stack<>();
        curr=root;
    }
    
    public int next() {
        while(curr!=null) {
            stack.push(curr);
            curr=curr.left;
        }
        curr=stack.pop();
        int nextValue=curr.val;
        curr=curr.right;
        return nextValue;
    }
    
    public boolean hasNext() {
        return curr!=null || !stack.isEmpty();
    }
}
