// t.c.=O(n), s.c.=O(n)
class Solution {
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
       ListNode dummy = new ListNode(0);
       dummy.next=head;
       Map<Integer, Integer> map = new HashMap<>();
       ListNode curr = dummy.next;
       while(curr!=null) {
           int val = curr.val;
           map.put(val, map.getOrDefault(val, 0)+1);
           curr=curr.next;
       }
       ListNode prev=dummy;
       while(prev.next!=null) {
           int val = prev.next.val;
           if(map.get(val)>1)
               prev.next=prev.next.next;
            else
                prev=prev.next;
       }
       return dummy.next;
    }
}
