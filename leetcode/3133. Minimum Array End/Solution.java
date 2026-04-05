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
