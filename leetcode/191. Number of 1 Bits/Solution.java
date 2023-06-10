// using bit manipulation
// t.c. depends on number of 1's in n O(1), s.c.=O(1)
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res=0;
        while(n!=0) {
            res++;
            n&=(n-1);
        }
        return res;
    }
}

// by fliping the mask bit
// t.c.=O(1), s.c.=O(1)
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res=0, mask=1;
        for(int i=0;i<32;i++) {
            if((n & mask)!=0)
                res++;
            mask<<=1;
        }
        return res;
    }
}
