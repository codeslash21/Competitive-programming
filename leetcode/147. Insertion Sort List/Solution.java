// t.c.=O(n), s.c.=O(1)
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode curr=head.next, prev=head;
        while(curr!=null) {
            ListNode start=dummy;
            while(start.next!=curr) {
                if(start.next.val>curr.val) {
                    ListNode temp=curr.next;
                    curr.next=start.next;
                    start.next=curr;
                    prev.next=temp;
                    curr=prev;
                    break;
                }
                start=start.next;
            }
            prev=curr;
            curr=curr.next;
        }
        return dummy.next;
    }
}
