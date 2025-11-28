// https://leetcode.com/problems/validate-stack-sequences/description/
// using stack
// t.c.=O(n), s.c.=O(n)
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int len=popped.length, idx1=0, idx2=0;
        Stack<Integer> stack=new Stack<>();
        while(idx1<len) {
            stack.push(pushed[idx1++]);
            while(!stack.isEmpty() && stack.peek()==popped[idx2]) {
                stack.pop();
                idx2++;
            }
        }
        return idx2==len;
    }
}
