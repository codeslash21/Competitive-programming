// https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/
// using stack
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(char ch:s.toCharArray()) {
            if(!stack.isEmpty() && ch==')' && stack.peek()=='(')
                stack.pop();
            else
                stack.push(ch);
        }
        return stack.size();
    }
}

// using counter
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int minAddToMakeValid(String s) {
        int openBrackets=0, minAddRequired=0;
        for(char ch:s.toCharArray()) {
            if(ch=='(')
                openBrackets++;
            else 
                if(openBrackets>0)
                    openBrackets--;
                else
                    minAddRequired++;
        }
        return openBrackets+minAddRequired;
    }
}
