// using recursion
// t.c.=O(n), s.c.=O(number of groups)
class Solution {
    private int pair;
    private ListNode reverseGroup(ListNode head, int k) {
        ListNode prev=null, curr=head;
        int size=k;
        while(size>0) {
            ListNode temp = curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
            size--;
        }
        if(--pair>0)
            head.next=reverseGroup(curr, k);
        else
            head.next=curr;
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        int n=0;
        ListNode curr=head;
        while(curr!=null) {
            curr=curr.next;
            n++;
        }
        pair=n/k;
        return reverseGroup(head, k);
    }
}
