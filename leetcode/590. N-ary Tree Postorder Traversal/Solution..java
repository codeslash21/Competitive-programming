// Using iterative approach
// t.c.=O(n), s.c.=O(1)
class Solution {
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node curr = stack.pop();
            if(curr!=null) {
                res.addFirst(curr.val);
                List<Node> children = curr.children;
                for(int i=0;i<children.size();i++)
                    stack.push(children.get(i));
            }
        }
        return res;
    }
}
