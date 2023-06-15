// Using dp iterative approach
// t.c.=O(m*n), s.c.=O(m*n)
class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length(), n=word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++)
            dp[i][0]=i;
        for(int i=0;i<=n;i++)
            dp[0][i]=i;
        for(int row=1;row<=m;row++)
            for(int col=1;col<=n;col++) {
                if(word1.charAt(row-1)==word2.charAt(col-1))
                    dp[row][col]=dp[row-1][col-1];
                else
                    dp[row][col]=1+Math.min(dp[row-1][col-1], Math.min(dp[row-1][col], dp[row][col-1]));
            }
        return dp[m][n];
    }
}
