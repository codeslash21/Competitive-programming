// https://leetcode.com/problems/factorial-trailing-zeroes/description/
// t.c.=O(n*log_5(n)), s.c.=O(1)
class Solution {
    public int trailingZeroes(int n) {
        int count=0, num=5;
        while(num<=n) {
            int val=num;
            while(val%5==0) {
                count++;
                val/=5;
            }
            num+=5;
        }
        return count;
    }
}

// using power of 5
// t.c.=O(log_5(n)), s.c.=O(1)
class Solution {
    public int trailingZeroes(int n) {
        int count=0;
        while(n>=5) {
            count+=n/5;
            n/=5;
        }
        return count;
    }
}
