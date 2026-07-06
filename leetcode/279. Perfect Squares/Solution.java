// https://leetcode.com/problems/perfect-squares/description/
// using recursion
// t.c.=O(sqrt(n)^n), s.c.=O(n)
class Solution {
    public int numSquares(int n) {
        if(n==0)    return 0;
        int result=n;
        for(int i=1;i*i<=n;i++)
            result=Math.min(result, 1+numSquares(n-i*i));
        return result;
    }
}

// using dp bottom-up
// t.c.=O(sqrt(n)*n), s.c.=O(n)
class Solution {
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp, n+1);
        dp[0]=0;
        for(int i=1;i<=n;i++)
            for(int j=1;j*j<=i;j++)
                dp[i]=Math.min(dp[i], dp[i-j*j]+1);
        return dp[n];
    }
}
