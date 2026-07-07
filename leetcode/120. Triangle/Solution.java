// https://leetcode.com/problems/triangle/description/
// using dp bottom-up
// t.c.=O(n^2), s.c.=O(n^2)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][] dp=new int[n][n];
        // fill the last row
        for(int col=0;col<n;col++)
            dp[n-1][col]=triangle.get(n-1).get(col);
        // fill the remaining cell
        for(int row=n-2;row>=0;row--)
            for(int col=0;col<triangle.get(row).size();col++)
                dp[row][col]=triangle.get(row).get(col)+Math.min(dp[row+1][col], dp[row+1][col+1]);
        return dp[0][0];
    }
}
