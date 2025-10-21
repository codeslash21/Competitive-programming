// https://leetcode.com/problems/arranging-coins/description/
// t.c.=O(sqrt(n)), s.c.=O(1)
class Solution {
    public int arrangeCoins(int n) {
        int row=1;
        while(n>0) 
            n-=row++;
        return n==0?row-1:row-2;
    }
}

// binary search
// t.c.=O(logn), s.c.=O(1)
class Solution {
    public int arrangeCoins(int n) {
        long left=1, right=n;
        while(left<=right) {
            long mid=left+(right-left)/2;
            long total=mid*(mid+1)/2;
            if(total<=n)
                left=mid+1;
            else
                right=mid-1;
        }
        return left*(left+1)/2==n?(int)left:(int)left-1;
    }
}
