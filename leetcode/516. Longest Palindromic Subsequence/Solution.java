// Using dp, iterative approach
// t.c.=O(n^2), s.c.=O(n^2)
class Solution {
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++)
            dp[i][i]=1;
        for(int len=2;len<=n;len++)
            for(int i=0;i<=n-len;i++) {
                int j=i+len-1;
                if(s.charAt(i)==s.charAt(j))
                    dp[i][j]=2+dp[i+1][j-1];
                else
                    dp[i][j]=Math.max(dp[i][j-1], dp[i+1][j]);
            }
        return dp[0][n-1];
    }
}

// using dp, recursive approach
// t.c.=O(n^2), s.c.=O(n^2)
class Solution {
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        int[][] memo = new int[n][n];
        return lps(s, 0, n-1, memo);
    }
    public int lps(String s, int i, int j, int[][] memo) {
        if(memo[i][j]!=0)
            return memo[i][j];
        if(i>j)
            return 0;
        if(i==j)
            return 1;
        if(s.charAt(i)==s.charAt(j))
            memo[i][j] = 2+lps(s, i+1, j-1, memo);
        else 
            memo[i][j]=Math.max(lps(s, i+1, j, memo), lps(s, i, j-1, memo));
        return memo[i][j];
    }
}
