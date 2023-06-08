// using dp
// t.c.=O(n^2), s.c.=O(n^2)
class Solution {
    public int countSubstrings(String s) {
        int n=s.length(), ans=0;
        boolean[][] dp = new boolean[n][n];
        for(int i=0;i<n;i++)
            dp[i][i]=true;
        ans+=n;
        for(int i=0;i<n-1;i++) {
            dp[i][i+1]=(s.charAt(i)==s.charAt(i+1));
            ans+=dp[i][i+1]?1:0;
        }
        for(int len=3;len<=n;len++) 
            for(int i=0, j=i+len-1; j<n; i++,j++) {
                dp[i][j]=dp[i+1][j-1] && s.charAt(i)==s.charAt(j);
                ans+=dp[i][j]?1:0;
            }
        return ans;
    }
}

// Expand around possible centers
// t.c.=O(n^2), s.c.=O(1)
class Solution {
    public int countSubstrings(String s) {
        int n=s.length(), ans=0;
        for(int i=0; i<s.length(); i++) {
            ans+=countPalindrome(s, i, i);
            ans+=countPalindrome(s, i, i+1);
        }
        return ans;
    }
    private int countPalindrome(String s, int lo, int hi) {
        int ans=0;
        while(lo>=0 && hi<s.length()) {
            if(s.charAt(lo)!=s.charAt(hi))
                break;
            lo--;
            hi++;
            ans++;
        }
        return ans;
    }
}
