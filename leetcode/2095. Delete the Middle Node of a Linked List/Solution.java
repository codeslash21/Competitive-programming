// t.c.=O(n), s.c.=O(1)
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        ListNode slow=head, fast=head, curr=head;
        while(fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        if(head==slow)
            return null;
        while(curr.next!=slow)
            curr=curr.next;
        if(curr!=null)
            curr.next=curr.next.next;
        return head;
    }
}
