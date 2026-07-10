// https://leetcode.com/problems/regular-expression-matching/description/
// using recursion
// t.c.=O(2^(m+n)), s.c.=O(m+n)
class Solution {
    public boolean isMatch(String s, String p) {
        return dfs(s, p, 0, 0, s.length(), p.length());
    }
    private boolean dfs(String s, String p, int idxS, int idxP, int m, int n) {
        if(idxP==n) return idxS==m;
        boolean match=idxS<m && (s.charAt(idxS)==p.charAt(idxP) || p.charAt(idxP)=='.');
        if(idxP+1<n && p.charAt(idxP+1)=='*')
            return dfs(s, p, idxS, idxP+2, m, n) || (match && dfs(s, p, idxS+1, idxP, m, n));
        if(match)
            return dfs(s, p, idxS+1, idxP+1, m, n);
        return false;
    }
}

// using dp
// t.c.=O(m*n), s.c.=O(m*n)
class Solution {
    public boolean isMatch(String s, String p) {
        int m=s.length(), n=p.length();
        boolean[][] dp=new boolean[m+1][n+1];
        dp[m][n]=true;
        for(int i=m;i>=0;i--)
            for(int j=n-1;j>=0;j--) {
                boolean match=i<m && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.');
                if(j+1<n && p.charAt(j+1)=='*')
                    dp[i][j]=dp[i][j+2] || (match && dp[i+1][j]);
                else if(match)
                    dp[i][j]=dp[i+1][j+1];
            }
        return dp[0][0];
    }
}
