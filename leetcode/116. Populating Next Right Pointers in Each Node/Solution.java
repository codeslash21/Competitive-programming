// Using bfs
// t.c.=O(n), s.c.=O(n)
class Solution {
    public Node connect(Node root) {
        Deque<Node> queue = new ArrayDeque<>();
        Node curr=null, prev=null;
        if(root!=null)
            queue.add(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            prev=null;
            for(int i=0;i<len;i++) {
                curr = queue.remove();
                if(prev!=null)
                    prev.next=curr;
                prev=curr;
                if(curr.left!=null)
                    queue.add(curr.left);
                if(curr.right!=null)
                    queue.add(curr.right);
            }
        }
        return root;
    }
}

// Using previosuly established next pointers
// t.c.=O(n), s.c.=O(1)
class Solution {
    public Node connect(Node root) {
        if(root==null)
            return root;
        Node leftMost = root;
        while(leftMost.left!=null) {
            Node head = leftMost;
            while(head!=null) {
                head.left.next = head.right;
                if(head.next!=null)
                    head.right.next = head.next.left;
                head=head.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }
}
