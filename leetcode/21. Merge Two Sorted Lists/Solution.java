// Using recursion
// t.c.=O(m+n), s.c.=O(m+n)
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null)
            return list2;
        else if(list2==null)
            return list1;
        else if(list1.val<list2.val) {
            list1.next=mergeTwoLists(list1.next, list2);
            return list1;
        }
        else {
            list2.next=mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}

// Iterative approach
// t.c.=O(m+n), s.c.=O(1)
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode preHead = new ListNode(-1), prev=preHead;
        while(list1!=null && list2!=null) {
            if(list1.val<list2.val) {
                prev.next=list1;
                list1=list1.next;
            }
            else {
                prev.next=list2;
                list2=list2.next;
            }
            prev=prev.next;
        }
        prev.next=list1==null?list2:list1;
        return preHead.next;
    }
}
