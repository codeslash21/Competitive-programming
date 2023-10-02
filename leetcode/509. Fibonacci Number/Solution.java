// using bottom-up approach, iterative
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int fib(int n) {
        if(n<2)
            return n;
        int curr=0, first=0, second=1;
        for(int i=2;i<=n;i++) {
            curr=first+second;
            first=second;
            second=curr;
        }
        return curr;
    }
}
