class Solution {
    public int mod = (int)1e9+7;
    public int countGoodNumbers(long n) {
        return (int)(binPow(4,n/2)*binPow(5, (n+1)/2)%mod);
    }
    public long binPow(long a, long b) {
        if(b==0)
            return 1;
        long res = binPow(a, b/2);
        return (res*res*(b%2>0?a:1))%mod;
    }
}
