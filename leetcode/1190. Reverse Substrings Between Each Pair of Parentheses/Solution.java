// https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/description/
// using recursion
// t.c.=O(n), s.c.=O(n)
class Solution {
    int idx=0;
    public String reverseParentheses(String s) {
        StringBuilder currStr=new StringBuilder();
        Stack<StringBuilder> stack=new Stack<>();
        while(idx<s.length()) {
            if(s.charAt(idx)=='(') {
                idx++;
                String innerStr=reverseParentheses(s);
                currStr.append(innerStr);
                idx++;
            } else if(s.charAt(idx)==')')
                return currStr.reverse().toString();
            else 
                currStr.append(s.charAt(idx++));
        }
        return currStr.toString();
    }
}
