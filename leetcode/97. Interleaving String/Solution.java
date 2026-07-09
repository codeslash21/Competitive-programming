// https://leetcode.com/problems/interleaving-string/description/
// using recursion
// t.c.=O(2&(m+n)), s.c.=O(m+n)
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        return dfs(0, 0, 0, s1, s2, s3);
    }
    private boolean dfs(int i, int j, int k, String s1, String s2, String s3) {
        if(k==s3.length())
            return i==s1.length() && j==s2.length();
        if(i<s1.length() && s1.charAt(i)==s3.charAt(k))
            if(dfs(i+1, j, k+1, s1, s2, s3))
                return true;
        if(j<s2.length() && s2.charAt(j)==s3.charAt(k))
            if(dfs(i, j+1, k+1, s1, s2, s3))
                return true;
        return false;
    }
}

// using dp
// t.c.=O(m*n), s.c.=O(m*n)
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m=s1.length(), n=s2.length();
        if(s3.length()!=m+n)    return false;
        boolean[][] dp=new boolean[m+1][n+1];
        dp[m][n]=true;
        for(int i=m;i>=0;i--)
            for(int j=n;j>=0;j--) {
                if(i<m && s1.charAt(i)==s3.charAt(i+j) && dp[i+1][j])
                    dp[i][j]=true;
                if(j<n && s2.charAt(j)==s3.charAt(i+j) && dp[i][j+1])
                    dp[i][j]=true;
            }
        return dp[0][0];
    }
}
