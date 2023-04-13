// Traversing two lists
// t.c.=O(max(n,m)), s.c.=O(1)
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), head=dummy;
        int carry=0, firstDigit=0, secondDigit=0;
        while(l1!=null || l2!=null) {
            firstDigit=l1==null?0:l1.val;
            secondDigit=l2==null?0:l2.val;
            int sum=firstDigit+secondDigit+carry;
            head.next=new ListNode(sum%10);
            head=head.next;
            carry=sum/10;
            l1=l1==null?null:l1.next;
            l2=l2==null?null:l2.next;
        }
        if(carry!=0)
            head.next = new ListNode(carry);
        return dummy.next;
    }
}
