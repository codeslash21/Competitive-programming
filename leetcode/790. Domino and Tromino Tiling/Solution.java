// https://leetcode.com/problems/domino-and-tromino-tiling/description
// using dp
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int numTilings(int n) {
        int mod=1_000_000_007;
        if(n<=2)    return n;
        long[] f=new long[n+1], p=new long[n+1];
        f[1]=1;
        f[2]=2;
        p[2]=2;
        for(int k=3;k<=n;k++) {
            f[k]=(f[k-1]+f[k-2]+p[k-1])%mod;
            p[k]=(p[k-1]+f[k-2]*2)%mod;
        }
        return (int)f[n];
    }
}
