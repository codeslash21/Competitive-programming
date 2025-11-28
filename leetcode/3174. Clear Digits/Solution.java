// https://leetcode.com/problems/clear-digits/description/
// using stack
// t.c.=O(n), s.c.=O(n)
class Solution {
    public String clearDigits(String s) {
        Stack<Character> stack=new Stack<>();
        StringBuilder sb=new StringBuilder();
        for(char ch:s.toCharArray()) {
            if(Character.isDigit(ch))
                stack.pop();
            else
                stack.push(ch);
        }
        for(Character ch:stack)
            sb.append(ch);
        return sb.toString();
    }
}
