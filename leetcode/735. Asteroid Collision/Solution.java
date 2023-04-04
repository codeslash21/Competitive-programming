// using stack
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack();
        for(int ast:asteroids) {
            boolean insert=true;
            while(!stack.isEmpty() && ast<0 && stack.peek()>0) {
                if(stack.peek()<-ast) {
                    stack.pop();
                    continue;
                }
                else if(stack.peek()==-ast){
                    stack.pop();
                    insert=false;
                }
                else
                    insert=false;
                break;
            }
            if(insert)
                stack.push(ast);
        }
        int[] ans = new int[stack.size()];
        for(int i=ans.length-1;i>=0;i--)
            ans[i]=stack.pop();
        return ans;
    }
}
