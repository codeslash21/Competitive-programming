// https://leetcode.com/problems/count-square-submatrices-with-all-ones/description/
// using bruteforce
// t.c.=O(m*n*min(m,n)^3), s.c.=O(1)
class Solution {
    public int countSquares(int[][] matrix) {
        int m=matrix.length, n=matrix[0].length;
        int count=0;
        for(int i=0;i<m;i++) 
            for(int j=0;j<n;j++) {
                if(matrix[i][j]==0) continue;
                int maxK=Math.min(m-i, n-j);
                for(int k=1;k<=maxK;k++) {
                    boolean allOne=true;
                    for(int r=i;r<i+k && allOne;r++) 
                        for(int c=j;c<j+k && allOne;c++) 
                            if(matrix[r][c]==0)
                                allOne=false;
                    if(allOne)  count++;
                    else    break;
                }
            }
        return count;
    }
}
// using dp bottom-up
// t.c.=O(m*n), s.c.=O(m*n)
class Solution {
    public int countSquares(int[][] matrix) {
        int m=matrix.length, n=matrix[0].length, count=0;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++) {
                if(matrix[i][j]==1)
                    if(i==0 || j==0)
                        dp[i][j]=1;
                    else
                        dp[i][j]=Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
                count+=dp[i][j];
            }
        return count;
    }
}
