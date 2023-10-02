// Using recursion
// t.c.=O(n), s.c.=O(n)
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node curr = stack.pop();
            if(curr!=null) {
                list.add(curr.val);
                List<Node> child = curr.children;
                for(int i=child.size()-1;i>=0;i--)
                    stack.push(child.get(i));
            }
        }
        return list;
    }
}
