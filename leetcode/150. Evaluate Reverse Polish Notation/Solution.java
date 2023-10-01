// using stack
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s:tokens) {
            if("+-*/".contains(s)) {
                int op2=stack.pop();
                int op1=stack.pop();
                if(s.equals("+"))
                    stack.push(op1+op2);
                else if(s.equals("-"))
                    stack.push(op1-op2);
                else if(s.equals("*"))
                    stack.push(op1*op2);
                else
                    stack.push(op1/op2);
            }
            else
                stack.push(Integer.parseInt(s));
        }
        return stack.pop();
    }
}
