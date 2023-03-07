// Using linear scan
// t.c.=O(n), s.c.=O(1)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null)
            return head;
        ListNode old_tail=head, new_tail=head;
        int n;
        for(n=1;old_tail.next!=null; n++)
            old_tail=old_tail.next;
        old_tail.next=head;
        k%=n;
        for(int i=1;i<n-k;i++)
            new_tail=new_tail.next;
        ListNode new_head=new_tail.next;
        new_tail.next=null;
        return new_head;
    }
}
