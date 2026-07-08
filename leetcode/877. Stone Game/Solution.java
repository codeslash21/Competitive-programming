// https://leetcode.com/problems/stone-game/description/
// using recursion
// t.c.=O(2^n), s.c.=O(n)
class Solution {
    public boolean stoneGame(int[] piles) {
        int totalScore=Arrays.stream(piles).sum();
        int aliceScore=getAliceScore(piles, 0, piles.length-1);
        return aliceScore>(totalScore-aliceScore);
    }
    private int getAliceScore(int[] piles, int start, int end) {
        if(start>end)   return 0;
        boolean aliceTurn=(end-start+1)%2==0;
        int left=aliceTurn?piles[start]:0;
        int right=aliceTurn?piles[end]:0;
        return Math.max(getAliceScore(piles, start+1, end)+left, 
                        getAliceScore(piles, start, end-1)+right);
    }
}

// using dp
// t.c.=O(n^2), s.c.=O(n^2)
class Solution {
    public boolean stoneGame(int[] piles) {
        int totalScore=Arrays.stream(piles).sum(), n=piles.length;
        int[][] dp=new int[n][n];
        for(int l=n-1;l>=0;l--)
            for(int r=l;r<n;r++) {
                boolean aliceTurn=(r-l+1)%2==0;
                int left=aliceTurn?piles[l]:0;
                int right=aliceTurn?piles[r]:0;
                if(l==r)    
                    dp[l][r]=0;
                else
                    dp[l][r]=Math.max(dp[l+1][r]+left, dp[l][r-1]+right);
            }
        return dp[0][n-1]>(totalScore-dp[0][n-1]);
    }
}
