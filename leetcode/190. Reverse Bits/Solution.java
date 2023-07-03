// t.c.=O(1), s.c.=O(1)
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int mask=1, res=0;
        for(int i=0;i<32;i++) {
            res=res*2+((n&mask)>0?1:0);
            n>>=1;
        }
        return res;
    }
}
