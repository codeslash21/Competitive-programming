// using hash table
// t.c.=O(n), s.c.=O(n)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodes = new HashSet<>();
        while(head!=null) {
            if(nodes.contains(head))
                return true;
            nodes.add(head);
            head=head.next;
        }
        return false;
    }
}

// Using Floyd's cycle detection algo
// t.c.=O(n), s.c.=O(1)
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null)
            return false;
        ListNode slow=head, fast=head.next;
        while(fast!=null) {
            if(fast==slow)
                return true;
            slow=slow.next;
            fast=fast.next==null?fast.next:fast.next.next;
        }
        return false;
    }
}
