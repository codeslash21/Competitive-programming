// Using recursion
// t.c.=O(n), s.c.=O(n)
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode prev=head, curr=head.next;
        ListNode temp=curr.next;
        curr.next=prev;
        prev.next=swapPairs(temp);
        return curr;
    }
}

// Iterative version
// t.c.=O(n), s.c.=O(1)
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode dummy = new ListNode(0), prev=dummy;
        dummy.next=head;
        while(head!=null && head.next!=null) {
            ListNode first = head, second=head.next;
            prev.next=second;
            first.next=second.next;
            second.next=first;
            prev=first;
            head=first.next;
        }
        return dummy.next;
    }
}
