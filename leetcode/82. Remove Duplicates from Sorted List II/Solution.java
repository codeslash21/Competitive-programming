// Using sentinel node and predecessor
// t.c.=O(n), s.c.=O(1)
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-200), curr=head, prev=dummy;
        dummy.next=head;
        boolean duplicate=false;
        while(curr!=null) {
            if(curr.next!=null && prev.next.val==curr.next.val)
                duplicate=true;
            else if(duplicate){
                prev.next=curr.next;
                duplicate=false;
            }
            else
                prev=prev.next;
            curr=curr.next;
        }
        return dummy.next;
    }
}
