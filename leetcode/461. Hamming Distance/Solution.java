// Using XOR
// t.c.=O(1), s.c.=O(1)
class Solution {
    public int hammingDistance(int x, int y) {
        int ans=0;
        x^=y;
        while(x!=0) {
            ans++;
            x&=(x-1);
        }
        return ans;
    }
}
