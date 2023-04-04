// Using 2-way merge procedure
// t.c.=O(kN), s.c.=O(1), where N is total number of elements in final list. t.c.= [i*(N/k) + (N/k)] i=1(1)k-1
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
    public ListNode mergeTwoLists(ListNode head, ListNode secondHead) {
        ListNode i=head, j=secondHead, prev=null;
        while(i!=null && j!=null) {
            if(i.val<=j.val){
                prev=i;
                i=i.next;
            }
            else {
                ListNode temp=j.next;
                j.next=i;
                if(prev==null) {
                    head=j;
                    prev=j;
                }
                else {
                    prev.next=j;
                    prev=prev.next;
                }
                j=temp;
            }
        }
        if(j!=null)
            prev.next=j;
        return head;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        int n=lists.length;
        if(n==0)
            return head;
        head=lists[0];
        for(int i=1;i<n;i++) {
            ListNode secondHead = lists[i];
            if(head==null)
                head=secondHead;
            else
                head = mergeTwoLists(head, secondHead);
        }
        return head;
    }
}

// By comparing one by one
// t.c.=O(kN), s.c.=O(1)
public ListNode mergeKLists(ListNode[] lists) {
    int min_index = 0;
    ListNode head = new ListNode(0);
    ListNode h = head;
    while (true) {
        boolean isBreak = true; 
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) { 
                if (lists[i].val < min) {
                    min_index = i;
                    min = lists[i].val;
                } 
                isBreak = false;
            }

        }
        if (isBreak) {
            break;
        } 
        ListNode a = new ListNode(lists[min_index].val);
        h.next = a;
        h = h.next; 
        lists[min_index] = lists[min_index].next;
    }
    h.next = null;
    return head.next;
}
