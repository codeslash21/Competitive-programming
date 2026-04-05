// https://leetcode.com/problems/minimum-array-end/description/
// t.c.=O(n), s.c.=O(1)
class Solution {
    public long minEnd(int n, int x) {
        long result=x;
        while(n-->1) 
            result=(result+1)|x;
        return result;
    }
}

// t.c.=O(logN), s.c.=O(1)
class Solution {
    public long minEnd(int n, int x) {
        long res=x, mask=1;
        n--;
        while(n>0) {
            if((x&mask)==0) {
                if((n&1)>0)
                    res|=mask;
                n>>=1;
            }
            mask<<=1;
        }
        return res;
    }
}
