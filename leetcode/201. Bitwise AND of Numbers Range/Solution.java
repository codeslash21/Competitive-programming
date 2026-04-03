// https://leetcode.com/problems/bitwise-and-of-numbers-range/description/
// using sift
// t.c.=O(1), s.c.=O(1)
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int shift=0;
        while(left!=right) {
            left>>=1;
            right>>=1;
            shift++;
        }
        return left<<shift;
    }
}

// using Brain Kernighan's algorithm
// t.c.=O(1), s.c.=O(1)
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        while(right>left) 
            right&=(right-1);
        return right;
    }
}
