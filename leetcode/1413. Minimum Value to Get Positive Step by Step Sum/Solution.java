// t.c.=O(n), s.c.=O(1)
class Solution {
    public int minStartValue(int[] nums) {
        int res=1, sum=0;
        for(int num:nums) {
            sum+=num;
            if(sum<1)
                res=Math.max(res, 1-sum);   
        }
        return res;
    }
}
