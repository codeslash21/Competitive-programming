// https://leetcode.com/problems/minimum-string-length-after-removing-substrings/description/
// stack
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int minLength(String s) {
        Stack<Character> stack=new Stack<>();
        for(char ch:s.toCharArray())
            if(!stack.isEmpty() && ((ch=='B' && stack.peek()=='A') || (ch=='D' && stack.peek()=='C')))
                stack.pop();
            else
                stack.push(ch);
        return stack.size();
    }
}
