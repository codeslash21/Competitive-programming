// Using brute-force approach
// t.c.=O(m*n), s.c.=O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        while (headA != null) {
            ListNode pB = headB;
            while (pB != null) {
                if (headA == pB) return headA;
                pB = pB.next;
            }
            headA = headA.next;
        }
        return null;
    }
}

// Using set
// t.c.=O(n+m), s.c.=O(n)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while(headA!=null){
            set.add(headA);
            headA=headA.next;
        }
        while(headB!=null){
            if(set.contains(headB))
                return headB;
            headB=headB.next;
        }
        return null;
    }
}

// Using two pointers
// t.c.=O(m+n), s.c.=O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA, pB = headB;
        while(pA!=pB) {
            pA=pA==null?headB:pA.next;
            pB=pB==null?headA:pB.next;
        }
        return pA;
    }
}
