// flipping least significant bit
// t.c.=O(nlogn), s.c.=O(1)
class Solution {
    public int helper(int i) {
        int res=0;
        while(i!=0) {
            res++;
            i&=(i-1);
        }
        return res;
    }
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for(int i=0;i<=n;i++)
            ans[i]=helper(i);
        return ans;
    }
}

// using dp and most significant bit
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        int x=0, b=1;
        while(b<=n) {
            x=0;
            while(x<b && (x+b)<=n) {
                ans[x+b]=ans[x]+1;
                x++;
            }
            b<<=1;
        }
        return ans;
    }
}

