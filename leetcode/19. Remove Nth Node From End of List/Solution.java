// Using single pass
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode p=dummy, q=head;
        int cnt=0;
        while(q!=null) {
            q=q.next;
            cnt++;
            if(cnt>n)
                p=p.next;
        }
        p.next=p.next.next;
        return dummy.next;
    }
}
