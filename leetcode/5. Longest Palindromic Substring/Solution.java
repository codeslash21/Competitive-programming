// using dp iterative approach
// t.c.=O(n^2), s.c.=O(n^2)
class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        boolean[][] dp = new boolean[n][n];
        int[] ans = new int[]{0,0};
        for(int i=0;i<n-1;i++) {
            dp[i][i]=true;
            if(s.charAt(i)==s.charAt(i+1)) {
                dp[i][i+1]=true;
                ans[0]=i;
                ans[1]=i+1;
            }
        }
        dp[n-1][n-1]=true;
        for(int diff=2;diff<n;diff++)
            for(int i=0;i<n-diff;i++)
                if(dp[i+1][i+diff-1] && s.charAt(i)==s.charAt(i+diff)) {
                    dp[i][i+diff]=true;
                    ans[0]=i;
                    ans[1]=i+diff;
                }
        return s.substring(ans[0], ans[1]+1);
    }
}

// using two pointers
// t.c.=O(n^2), s.c.=O(1)
class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        int[] ans = new int[]{0,0};
        for(int i=0;i<n;i++) {
            int oddLen = expand(s, i, i);
            if(oddLen>ans[1]-ans[0]+1) {
                ans[0]=i-oddLen/2;
                ans[1]=i+oddLen/2;
            }
            int evenLen = expand(s, i, i+1);
            if(evenLen>ans[1]-ans[0]+1) {
                ans[0]=i+1-evenLen/2;
                ans[1]=i+evenLen/2;
            }
        }
        return s.substring(ans[0], ans[1]+1);
    }
    public int expand(String s, int i, int j) {
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)) {
            i--;
            j++;
        }
        return j-i-1;
    }
}
