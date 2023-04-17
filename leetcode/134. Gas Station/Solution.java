// Using one pass
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start=0, sum=0, diff=0;
        int n=gas.length;
        for(int i=0;i<n;i++) {
            sum+=gas[i]-cost[i];
            if(sum<0) {
                start=i+1;
                diff+=sum;
                sum=0;
            }
        }
        return (sum+diff)>=0? start:-1;
    }
}
