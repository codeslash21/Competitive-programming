// Using dp
// t.c.=O(n), s.c.=O(n)
class Solution {
    int M = 1000000007;
    public int numDecodings(String s) {
        int n=s.length();
        Long[] memo = new Long[n];
        return (int)ways(s, n-1, memo);
    }
    private long ways(String s, int i, Long[] memo) {
        if(i<0)
            return 1;
        if(memo[i]!=null)
            return memo[i];
        if(s.charAt(i)=='*') {
            long res = (9*ways(s, i-1, memo))%M;
            if(i>0 && s.charAt(i-1)=='1')
                res=(res+9*ways(s, i-2, memo))%M;
            else if(i>0 && s.charAt(i-1)=='2')
                res=(res+6*ways(s, i-2, memo))%M;
            else if(i>0 && s.charAt(i-1)=='*')
                res=(res+15*ways(s, i-2, memo))%M;
            memo[i]=res;
            return memo[i];
        }
        long res=s.charAt(i)!='0'?ways(s, i-1, memo):0;
        if(i>0 && s.charAt(i-1)=='1')
            res=(res+ways(s, i-2, memo))%M;
        else if(i>0 && s.charAt(i-1)=='2' && s.charAt(i)<'7')
            res=(res+ways(s, i-2, memo))%M;
        else if(i>0 && s.charAt(i-1)=='*')
            res=(res+(s.charAt(i)<'7'?2:1)*ways(s, i-2, memo))%M;
        memo[i]=res;
        return memo[i];
    }
}
