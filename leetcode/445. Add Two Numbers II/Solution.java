// by reversing the lists
// t.c.=O(m+n), s.c.=O(1)
class Solution {
    private ListNode reverse(ListNode head) {
        ListNode prev=null, curr=head;
        while(curr!=null) {
            ListNode temp = curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
    private ListNode addList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), head=dummy;
        int carry=0;
        while(l1!=null || l2!=null) {
            int first=l1==null?0:l1.val;
            int second=l2==null?0:l2.val;
            int sum = first +second + carry;
            head.next = new ListNode(sum%10);
            carry=sum/10;
            head = head.next;
            l1=l1==null?null:l1.next;
            l2=l2==null?null:l2.next;
        }
        if(carry!=0)
            head.next = new ListNode(carry);
        return dummy.next;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1=reverse(l1);
        l2=reverse(l2);
        ListNode result = addList(l1, l2);
        return reverse(result);
    }
}

// Without reversing the LL
// t.c.=O(m+n), s.c.=O(1)
class Solution {
    private ListNode reverse(ListNode head) {
        ListNode prev=null, curr=head;
        while(curr!=null) {
            ListNode temp = curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
    private ListNode addList(ListNode l1, ListNode l2) {
        int n1=0, n2=0;
        ListNode curr=l1, head = null;
        while(curr!=null) {
            n1++;
            curr=curr.next;
        }
        curr=l2;
        while(curr!=null) {
            n2++;
            curr = curr.next;
        }
        while(n1>0 && n2>0) {
            int val=0;
            if(n1>=n2) {
                val+=l1.val;
                n1--;
                l1=l1.next;
            }
            if(n2>n1) {
                val+=l2.val;
                n2--;
                l2=l2.next;
            }
            ListNode node = new ListNode(val);
            node.next=head;
            head=node;
        }
        return head;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = addList(l1, l2), curr=result;
        int carry=0, sum=0;
        while(curr.next!=null) {
            sum=curr.val+carry;
            curr.val=sum%10;
            carry=sum/10;
            curr=curr.next;
        }
        curr.val=curr.val+carry;
        if(curr.val>9) {
            curr.next = new ListNode(1);
            curr.val=curr.val%10;
        }
        return reverse(result);
    }
}
