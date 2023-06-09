// Using dp
// t.c.=O(s*p), s.c.=O(s*p)
class Solution {
    public boolean isMatch(String s, String p) {
        int lens=s.length(), lenp=p.length();
        boolean[][] dp = new boolean[lenp+1][lens+1];
        if(p.equals(s))
            return true;
        if(lenp>0 && p.chars().allMatch(c->c=='*'))
            return true;
        if(lens==0 || lenp==0)
            return false;
        dp[0][0]=true;
        for(int i=1;i<=lenp;i++) {
            if(p.charAt(i-1)=='*') {
                int sIdx=0;
                while(sIdx<=lens && !dp[i-1][sIdx])
                    sIdx++;
                while(sIdx<=lens)
                    dp[i][sIdx++]=true;
            }
            else if(p.charAt(i-1)=='?')
                for(int sIdx=1;sIdx<=lens;sIdx++)
                    dp[i][sIdx] = dp[i-1][sIdx-1];
            else
                for(int sIdx=1;sIdx<=lens;sIdx++)
                    dp[i][sIdx] = dp[i-1][sIdx-1] && p.charAt(i-1)==s.charAt(sIdx-1);
        }
        return dp[lenp][lens];
    }
}
