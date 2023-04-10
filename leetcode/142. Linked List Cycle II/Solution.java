// Using floyd's tortoise hare algo
// t.c.=O(n), s.c.=O(1)
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head, fast=head;
        boolean cycle=false;
        while(fast!=null && fast.next!=null) {
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast) {
                cycle=true;
                break;
            } 
        }
        if(!cycle)
            return null;
        slow=head;
        while(slow!=fast) {
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}
