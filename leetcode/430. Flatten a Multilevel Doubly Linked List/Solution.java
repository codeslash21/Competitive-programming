// Using recursion
// t.c.=O(n), s.c.=O(number of rows)
class Solution {
    private Node[] scan(Node head) {
        Node prev=null, curr=head;
        while(curr!=null) {
            if(curr.child!=null) {
                Node temp=curr.next;
                Node[] res = scan(curr.child);
                curr.next=res[0];
                res[0].prev=curr;
                res[1].next=temp;
                if(temp!=null)
                    temp.prev=res[1];
                curr.child=null;
                curr=temp;
                prev=res[1];
            }
            else {
                prev=curr;
                curr=curr.next;
            }
        }
        return new Node[]{head, prev};
    }
    public Node flatten(Node head) {
        Node[] nodes = scan(head);
        return nodes[0];
    }
}
