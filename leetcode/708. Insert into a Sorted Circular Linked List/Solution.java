// Using two pointers
// t.c.=O(n), s.c.=O(1)
class Solution {
    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if(head==null) {
            node.next=node;
            return node;
        }
        Node prev=head, curr=head.next;
        boolean toInsert=false;
        do {
            if(prev.val<=insertVal && insertVal<=curr.val)
                toInsert=true;
            else if(prev.val>curr.val)
                if(prev.val<=insertVal || insertVal<=curr.val)
                    toInsert=true;
            if(toInsert) {
                prev.next=node;
                node.next=curr;
                return head;
            }
            prev=curr;
            curr=curr.next;
        } while(prev!=head);
        prev.next=node;
        node.next=curr;
        return head;
    }
}
