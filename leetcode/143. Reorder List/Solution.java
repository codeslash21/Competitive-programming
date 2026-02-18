// https://leetcode.com/problems/reorder-list/description/
// t.c.=O(n), s.c.=O(1)
class Solution {
    private ListNode findMid(ListNode head) {
        ListNode slow=head, fast=head;
        while(fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode head) {
        ListNode prev=null, curr=head, next=null;
        while(curr!=null) {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    private void mergeList(ListNode first, ListNode second) {
        ListNode next=null;
        while(second.next!=null) {
            next=first.next;
            first.next=second;
            first=next;

            next=second.next;
            second.next=first;
            second=next;
        }
    }
     public void reorderList(ListNode head) {
        ListNode mid=findMid(head), firstHead=head, secondHead=null;
        secondHead=reverse(mid);
        mergeList(firstHead, secondHead);
    }
}
