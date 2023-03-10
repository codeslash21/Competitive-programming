// Using inbuilt sort function
//t.c.=O(nlogn), s.c.=O(n)
class Solution {
    public ListNode sortList(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        int len=0;
        ListNode curr=head;
        while(curr!=null) {
            arr.add(curr.val);
            curr=curr.next;
            len++;
        }
        if(len<2)
            return head;
        Collections.sort(arr);
        curr=head;
        int i=0;
        while(curr!=null) {
            curr.val=arr.get(i++);
            curr=curr.next;
        }
        return head;
    }
}

// Using merge sort
// t.c.=O(nlogn), s.c.=O(logn)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode mid=getMid(head);
        ListNode left=sortList(head);
        ListNode right=sortList(mid);
        return merge(left, right);
    }
    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummyHead=new ListNode();
        ListNode tail=dummyHead;
        while(list1!=null && list2!=null) {
            if(list1.val<list2.val) {
                tail.next=list1;
                list1=list1.next;
                tail=tail.next;
            }
            else {
                tail.next=list2;
                list2=list2.next;
                tail=tail.next;
            }
        }
        tail.next=(list1!=null)? list1:list2;
        return dummyHead.next; 
    }

    public ListNode getMid(ListNode head) {
        ListNode midPrev=null;
        while(head!=null && head.next!=null) {
            midPrev=(midPrev==null)?head:midPrev.next;
            head=head.next.next;
        }
        ListNode mid=midPrev.next;
        midPrev.next=null;
        return mid;
    }
}
