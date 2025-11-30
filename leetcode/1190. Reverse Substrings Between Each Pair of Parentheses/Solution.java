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

// using wormhole teleportation
// t.c.=O(n), s.c.=O(n)
class Solution {
    public String reverseParentheses(String s) {
        int len=s.length();
        Stack<Integer> parenthesisIndices=new Stack<>();
        StringBuilder sb=new StringBuilder();
        int[] pair=new int[len];
        for(int i=0;i<len;i++) 
            if(s.charAt(i)=='(')
                parenthesisIndices.push(i);
            else if(s.charAt(i)==')') {
                int j=parenthesisIndices.pop();
                pair[j]=i;
                pair[i]=j;
            }
        for(int currIdx=0, direction=1;currIdx<len;currIdx+=direction) {
            if(s.charAt(currIdx)=='(' || s.charAt(currIdx)==')') {
                currIdx=pair[currIdx];
                direction=-direction;
            } else
                sb.append(s.charAt(currIdx));
        }
        return sb.toString();
    }
}
