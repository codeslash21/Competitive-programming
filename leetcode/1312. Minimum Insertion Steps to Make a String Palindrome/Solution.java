// Using dp
// t.c.=O(n^2), s.c.=O(^2)
class Solution {
    public int minInsertions(String s) {
        int n=s.length();
        int[][] dp = new int[n][n];
        for(int[] arr:dp)
            Arrays.fill(arr, -1);
        return n-maxLen(dp, s, 0, n-1);
    }
    private int maxLen(int[][] dp, String s, int start, int end) {
        int val=0;
        if(start>end)
            return 0;
        if(dp[start][end]!=-1)
            return dp[start][end];
        if(start==end) 
            val=1;
        else if(s.charAt(start)==s.charAt(end))
            val=2+maxLen(dp, s, start+1, end-1);
        else
            val=Math.max(maxLen(dp, s, start+1, end), maxLen(dp, s, start, end-1));
        dp[start][end]=val;
        return dp[start][end];
    }
}
