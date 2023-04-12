// Using array
// t.c.=O(n), s.c.=O(n)
class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        ListNode curr=head;
        while(curr!=null) {
            arr.add(curr.val);
            curr=curr.next;
        }
        int start=0, end=arr.size()-1;
        while(start<end) 
            if(!arr.get(start++).equals(arr.get(end--)))
                return false;
        return true;
    }
}

// Using recursion
// t.c.=O(n), s.c.=O(n)
class Solution {
    private ListNode front;
    private boolean recursivelyCheck(ListNode curr) {
        if(curr!=null) {
            if(!recursivelyCheck(curr.next))
                return false;
            if(curr.val!=front.val)
                return false;
            front=front.next;
        }
        return true;
    }
    public boolean isPalindrome(ListNode head) {
        front=head;
        return recursivelyCheck(head);
    }
}

// Reversing the second half
// t.c.=O(n), s.c.=O(1)
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null)
            return false;
        ListNode firstHalfEnd = findMid(head);
        ListNode secondHalfStart = reverse(firstHalfEnd.next);
        ListNode p1=head, p2=secondHalfStart;
        boolean result=true;
        while(result && p2!=null) {
            if(p1.val!=p2.val)
                result=false;
            p1=p1.next;
            p2=p2.next;
        }
        firstHalfEnd.next=reverse(secondHalfStart);
        return result;
    }
    private ListNode findMid(ListNode head) {
        ListNode slow=head, fast=head;
        while(fast.next!=null && fast.next.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
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
}
