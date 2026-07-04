// https://leetcode.com/problems/n-th-tribonacci-number/description/
// using dp (bottom-up)
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int tribonacci(int n) {
        int t0=0, t1=1, t2=1;
        if(n==0)    return t0;
        if(n==1)    return t1;
        if(n==2)    return t2;
        for(int i=3;i<=n;i++) {
            int ti=t0+t1+t2;
            t0=t1;
            t1=t2;
            t2=ti;
        }
        return t2;
    }
}
