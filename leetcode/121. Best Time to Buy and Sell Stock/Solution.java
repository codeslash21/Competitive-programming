// Using one pass
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int maxProfit(int[] nums) {
        int min=Integer.MAX_VALUE, res=0;
        Stack<Integer> stack = new Stack<>();
        for(int num:nums) 
            if(num<min)
                min=num;
            else
                res=Math.max(res, num-min);
        return res;
    }
}
