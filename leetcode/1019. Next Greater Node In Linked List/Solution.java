// Using stack
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> values = new ArrayList<>();
        while(head!=null) {
            values.add(head.val);
            head=head.next;
        }
        int n=values.size();
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++) {
            while(!stack.isEmpty() && values.get(stack.peek())<values.get(i)) {
                res[stack.peek()]=values.get(i);
                stack.pop();
            }
            stack.add(i);
        }
        return res;
    }
}

// using stack and one pass
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> values = new ArrayList<>();
        Stack<int[]> stack = new Stack<>();
        int cnt=0;
        while(head!=null) {
            values.add(0);
            while(!stack.isEmpty() && stack.peek()[1]<head.val) {
                int[] curr = stack.peek();
                values.set(curr[0], head.val);
                stack.pop();
            }
            stack.add(new int[] {cnt++, head.val});
            head = head.next;
        }
        return values.stream().mapToInt(i -> i).toArray();
    }
}
