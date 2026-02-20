// https://leetcode.com/problems/reverse-linked-list-ii/description/
// t.c.=O(n), s.c.=O(1)
class Solution {
    private ListNode reverse(ListNode left, ListNode right, ListNode prev) {
        ListNode end=right.next;
        while(left!=end) {
            ListNode next=left.next;
            left.next=prev;
            prev=left;
            left=next;
        }
        return prev;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy=new ListNode(0), leftNode=null, rightNode=null, curr=dummy;
        dummy.next=head;
        int cnt=0;
        while(curr!=null) {
            if(cnt==left-1)
                leftNode=curr;
            else if(cnt==right)
                rightNode=curr;
            curr=curr.next;
            cnt++;
        }
        leftNode.next=reverse(leftNode.next, rightNode, rightNode.next);
        return dummy.next;
    }
}
