// https://leetcode.com/problems/sum-of-two-integers/description/
// t.c.=O(1), s.c.=O(1)
class Solution {
    public int getSum(int a, int b) {
        int xor=a^b;
        int and=a&b;
        return xor+(2*and);
    }
}
