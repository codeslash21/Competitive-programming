// https://leetcode.com/problems/daily-temperatures/description/
// using stack
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len=temperatures.length;
        int[] res=new int[len];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<len;i++) {
            while(!stack.isEmpty() && temperatures[stack.peek()]<temperatures[i]) {
                int idx=stack.pop();
                res[idx]=i-idx;
            }
            stack.push(i);
        }
        return res;
    }
}
