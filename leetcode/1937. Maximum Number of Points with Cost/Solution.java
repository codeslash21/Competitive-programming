// https://leetcode.com/problems/maximum-number-of-points-with-cost/description/
// using recursion
// t.c.=O(n^m), s.c.=O(m)
class Solution {
    public long maxPoints(int[][] points) {
        int cols=points[0].length;
        long sum=0;
        for(int col=0;col<cols;col++)
            sum=Math.max(sum, dfs(points, 0, col)+points[0][col]);
        return sum;
    }
    private long dfs(int[][] points, int row, int col) {
        if(row==points.length-1)  return 0;
        long res=0;
        for(int c=0;c<points[0].length;c++)
            res=Math.max(res, points[row+1][c]-Math.abs(c-col)+dfs(points, row+1, c));
        return res;
    }
}

// using dp
// t.c.=O(m*n^2), s.c.=O(m*n)
class Solution {
    public long maxPoints(int[][] points) {
        int m=points.length, n=points[0].length;
        long[][] dp=new long[m][n];
        for(int col=0;col<n;col++)
            dp[m-1][col]=points[m-1][col];
        for(int row=m-2;row>=0;row--)
            for(int col=0;col<n;col++) {
                long best=Long.MIN_VALUE;
                for(int c=0;c<n;c++)
                    best=Math.max(best, dp[row+1][c]-Math.abs(c-col));
                dp[row][col]=best+points[row][col];
            }
        long result=Long.MIN_VALUE;
        for(long pathSum:dp[0])
            result=Math.max(result, pathSum);
        return result;
    }
}

// optimized time complexity for dp
// t.c.=O(m*n), s.c.=O(m*n)
class Solution {
    public long maxPoints(int[][] points) {
        int m=points.length, n=points[0].length;
        long[][] dp=new long[m][n];
        for(int col=0;col<n;col++)
            dp[m-1][col]=points[m-1][col];
        for(int row=m-2;row>=0;row--) {
            long[] left=new long[n], right=new long[n];
            left[0]=dp[row+1][0];
            for(int c=1;c<n;c++)
                left[c]=Math.max(left[c-1], dp[row+1][c]+c);
            right[n-1]=dp[row+1][n-1]-n+1;
            for(int c=n-2;c>=0;c--)
                right[c]=Math.max(right[c+1], dp[row+1][c]-c);
            for(int col=0;col<n;col++)
                dp[row][col]=Math.max(left[col]-col, right[col]+col)+points[row][col];
        }
        long result=Long.MIN_VALUE;
        for(long pathSum:dp[0])
            result=Math.max(result, pathSum);
        return result;
    }
}
