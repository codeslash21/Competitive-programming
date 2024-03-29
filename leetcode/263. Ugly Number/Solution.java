// by definition
// t.c.=O(logn), s.c.=O(1)
class Solution {
    public boolean isUgly(int n) {
        while(n>1) {
            if(n%5==0)
                n/=5;
            else if(n%3==0)
                n/=3;
            else if(n%2==0)
                n/=2;
            else
                return false;
        }
        return n>0;
    }
}
