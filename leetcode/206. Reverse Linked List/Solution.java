// Using iterative approach
// t.c.=O(n), s.c.=O(1)
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        while(head!=null) {
            ListNode temp = head.next;
            head.next=prev;
            prev=head;
            head=temp;
        }
        return prev;
    }
}

// Using recursion
// t.c.=O(n), s.c.=O(n)
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode p = reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return p;
    }
}
