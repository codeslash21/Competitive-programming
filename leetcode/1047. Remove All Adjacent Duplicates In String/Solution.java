// Using stack
//t.c.=O(n), s.c.=O(n)
class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for(Character c:s.toCharArray())
            if(stack.isEmpty() || c!=stack.peek())
                stack.push(c);
            else
                stack.pop();
        String res = "";
        for(Character c:stack)
            res+=c;
        return res;
    }
}
