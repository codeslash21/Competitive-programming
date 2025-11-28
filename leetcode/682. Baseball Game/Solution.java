// https://leetcode.com/problems/baseball-game/description/
// using stack
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack=new Stack<>();
        for(String op:operations) {
            if(op.equals("+")) {
                int first=stack.pop();
                int second=stack.peek();
                stack.push(first);
                stack.push(first+second);
            } else if(op.equals("C"))
                stack.pop();
            else if(op.equals("D"))
                stack.push(2*stack.peek());
            else
                stack.push(Integer.valueOf(op));
        }
        return stack.stream().mapToInt(Integer::intValue).sum();
    }
}
