// https://leetcode.com/problems/basic-calculator-ii/description/
// using stack
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int calculate(String s) {
        int len=s.length(), currNum=0, res=0;
        char prevOperation='+';
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<len;i++) {
            char currChar=s.charAt(i);
            if(Character.isDigit(currChar))
                currNum=currNum*10 + (currChar-'0');
            if((!Character.isDigit(currChar) && !Character.isWhitespace(currChar)) || i==len-1) {
                if(prevOperation=='+')
                    stack.push(currNum);
                else if(prevOperation=='-')
                    stack.push(-currNum);
                else if(prevOperation=='*')
                    stack.push(stack.pop()*currNum);
                else
                    stack.push(stack.pop()/currNum);
                currNum=0;
                prevOperation=currChar;
            }
        }
        for(int num:stack)
            res+=num;
        return res;
    }
}
