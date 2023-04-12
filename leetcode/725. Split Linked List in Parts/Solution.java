// By spliting the list
// t.c.=O(n+k), s.c.=O(k)
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        ListNode curr = head;
        int n=0;
        while(curr!=null) {
            curr=curr.next;
            n++;
        }
        int width=n/k, rem=n%k;
        curr=head;
        for(int i=0;i<k;i++) {
            ListNode listHead = curr;
            for(int j=0;j<width+(i<rem?1:0)-1;j++)
                curr=curr.next;
            if(curr!=null) {
                ListNode temp=curr.next;
                curr.next=null;
                curr=temp;
            }
            res[i]=listHead;
        }
        return res;
    }
}

// Without modifying the LL
// t.c.=O(n+k), s.c.=O(max(n,k))
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        ListNode curr = head;
        int n=0;
        while(curr!=null) {
            curr=curr.next;
            n++;
        }
        int width=n/k, rem=n%k;
        curr=head;
        for(int i=0;i<k;i++) {
            ListNode listHead=new ListNode(0), write=listHead;
            for(int j=0; j<width+(i<rem?1:0); j++) {
                write = write.next=new ListNode(curr.val);
                curr=curr.next;
            }
            res[i]=listHead.next;
        }
        return res;
    }
}
