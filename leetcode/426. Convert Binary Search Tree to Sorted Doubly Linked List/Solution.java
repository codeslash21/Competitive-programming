// recursive inorder traversal
// t.c.=O(n), s.c.=O(n)
class Solution {
    Node first = null, last = null;
    private void helper(Node node) {
        if(node==null)
            return;
        helper(node.left);
        if(last!=null) {
            node.left=last;
            last.right=node;
        }
        else
            first=node;
        last=node;
        helper(node.right);
    }
    public Node treeToDoublyList(Node root) {
        if(root==null)
            return null;
        helper(root);
        last.right=first;
        first.left=last;
        return first;
    }
}
