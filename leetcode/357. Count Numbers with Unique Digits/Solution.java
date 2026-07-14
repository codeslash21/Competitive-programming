// https://leetcode.com/problems/count-numbers-with-unique-digits/
// using dp
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0)    return 1;
        int result=10, uniqueDigits=9, availableDigits=9;
        for(int i=2;i<=n;i++) {
            uniqueDigits*=availableDigits;
            result+=uniqueDigits;
            availableDigits--;
        }
        return result;
    }
}
