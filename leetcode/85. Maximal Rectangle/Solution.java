// using dp iterative approach
// t.c.=O(m^2*n), s.c.=O(m*n)
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m=matrix.length, n=matrix[0].length;
        int[][] dp = new int[m][n];
        int maxArea=0;
        for(int i=0;i<m;i++) 
            for(int j=0;j<n;j++) 
                if(matrix[i][j]=='1') {
                    dp[i][j]=j==0?1:dp[i][j-1]+1;
                    int maxWidth=dp[i][j];
                    for(int k=i;k>=0;k--) {
                        maxWidth=Math.min(maxWidth, dp[k][j]);
                        maxArea=Math.max(maxArea, (i-k+1)*maxWidth);
                    }
                }
        return maxArea;
    }
}
