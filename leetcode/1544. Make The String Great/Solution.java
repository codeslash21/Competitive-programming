// https://leetcode.com/problems/make-the-string-great/description/
// using stack
// t.c.=O(n), s.c.=O(n)
class Solution {
    public String makeGood(String s) {
        Stack<Character> stack=new Stack<>();
        StringBuilder sb=new StringBuilder();
        for(char ch:s.toCharArray()) {
            if(!stack.isEmpty() && Math.abs(stack.peek()-ch)==('a'-'A'))
                stack.pop();
            else
                stack.push(ch);
        }
        while(!stack.isEmpty()) 
            sb.append(stack.pop());
        return sb.reverse().toString();
    }
}

// using two pointers
// t.c.=O(n), s.c.=O(n)
class Solution {
    public String makeGood(String s) {
        int len=s.length(), left=1, right=1;
        char[] chars=s.toCharArray();
        while(right<len) {
            if(left>0 && Math.abs(chars[right]-chars[left-1])==32)
                left--;
            else
                chars[left++]=chars[right];
            right++;
        }
        return new String(chars, 0, left);
    }
}
