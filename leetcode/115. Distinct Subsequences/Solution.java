// https://leetcode.com/problems/distinct-subsequences/description/
// using recursion
// t.c.=O(2^m), s.c.=O(m)
class Solution {
    public int numDistinct(String s, String t) {
        return dfs(s, t, 0, 0);
    }
    private int dfs(String s, String t, int idxS, int idxT) {
        if(idxT==t.length())    return 1;
        if(idxS==s.length())    return 0;
        int res=dfs(s, t, idxS+1, idxT);
        if(s.charAt(idxS)==t.charAt(idxT))
            res+=dfs(s, t, idxS+1, idxT+1);
        return res;
    }
}

// using dp
// t.c.=O(m*n), s.c.=O(m*n)
class Solution {
    public int numDistinct(String s, String t) {
        int m=s.length(), n=t.length();
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++)   dp[i][n]=1;
        for(int i=m-1;i>=0;i--)
            for(int j=n-1;j>=0;j--) {
                dp[i][j]=dp[i+1][j];    // skip s[i]
                // include s[i] if s[i]==t[j]
                if(s.charAt(i)==t.charAt(j))
                    dp[i][j]+=dp[i+1][j+1];
            }
        return dp[0][0];
    }
}
