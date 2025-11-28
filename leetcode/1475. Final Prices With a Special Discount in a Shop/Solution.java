// https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/description/
// using stack
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int[] finalPrices(int[] prices) {
        int len=prices.length;
        int[] res=new int[len];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<len;i++) {
            while(!stack.isEmpty() && prices[stack.peek()]>=prices[i]) {
                int idx=stack.pop();
                res[idx]=prices[idx]-prices[i];
            }  
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            int idx=stack.pop();
            res[idx]=prices[idx];
        }
        return res;
    }
}
