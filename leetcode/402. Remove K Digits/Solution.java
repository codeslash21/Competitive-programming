// https://leetcode.com/problems/remove-k-digits/description/
// using stack
// t.c.=O(n), s.c.=O(n)
class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack=new Stack<>();
        StringBuilder sb=new StringBuilder();
        boolean leadingZero=true;
        for(Character ch:num.toCharArray()) {
            while(!stack.isEmpty() && k>0 && ch<stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(ch);
        }
        while(k-->0)
            stack.pop();
        for(Character ch:stack) {
            if(ch=='0' && leadingZero)
                continue;
            leadingZero=false;
            sb.append(ch);
        }
        return sb.length()==0?"0":sb.toString();
    }
}
