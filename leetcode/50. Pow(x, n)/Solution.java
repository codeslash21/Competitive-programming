// using binary exponentiation
// t.c.=O(logn), s.c.=O(logn)
class Solution {
    public double myPow(double x, int n) {
        return binExp(x, n);
    }
    public double binExp(double x, long n) {
        if(n==0)
            return 1;
        if(n<0)
            return 1/binExp(x, -1*n);
        if(n%2==1)
            return x*binExp(x*x, n/2);
        return binExp(x*x, n/2);
    }
}
