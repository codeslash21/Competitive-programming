// https://leetcode.com/problems/k-th-symbol-in-grammar/description/
// using binary tree traversal
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int depthFirstSearch(int n, int k, int rootVal) {
        int totalLeaves=(int)Math.pow(2, n-1), mid=totalLeaves/2;
        if(n==1)
            return rootVal;
        if(k>mid)
            return depthFirstSearch(n-1, k-mid, rootVal==0?1:0);
        else
            return depthFirstSearch(n-1, k, rootVal==0?0:1);
    }
    public int kthGrammar(int n, int k) {
        return depthFirstSearch(n, k, 0);
    }
}
