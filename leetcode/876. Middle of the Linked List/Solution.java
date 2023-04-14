// Using two pointers
// t.c.=O(n), s.c.=O(1)
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow=head, fast=head;
        while(fast.next!=null && fast.next.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        return fast.next==null?slow:slow.next;
    }
}
