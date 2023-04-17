// using stack
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        for(int i=2*n-1;i>=0;i--) {
            while(!stack.isEmpty() && stack.peek()<=nums[i%n])
                stack.pop();
            res[i%n]=stack.isEmpty()?-1:stack.peek();
            stack.push(nums[i%n]);
        }
        return res;
    }
}
