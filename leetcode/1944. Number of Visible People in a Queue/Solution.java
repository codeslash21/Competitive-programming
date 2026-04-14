// https://leetcode.com/problems/number-of-visible-people-in-a-queue/description/
// using stack
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int len=heights.length;
        int[] res=new int[len];
        Stack<Integer> stack=new Stack<>();
        for(int i=len-1;i>=0;i--) {
            int count=0, height=heights[i];
            while(!stack.isEmpty() && height>stack.peek()) {
                stack.pop();
                count++;
            }
            if(!stack.isEmpty())
                count++;
            res[i]=count;
            stack.push(height);
        }
        return res;
    }
}
