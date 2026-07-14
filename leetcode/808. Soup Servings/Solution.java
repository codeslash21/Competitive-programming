// https://leetcode.com/problems/soup-servings/description/
// t.c.=O(m^2), s.c.=O(m^2), where m=n/25;
class Solution {
    public double soupServings(int n) {
        int m=(int)Math.ceil(n/25.0);
        if(m>=200)  return 1.0;
        double[][] dp=new double[m+1][m+1];
        int[][] dirs=new int[][]{{-4, 0}, {-3, -1}, {-2, -2}, {-1, -3}};
        dp[0][0]=.5;
        for(int j=1;j<=m;j++)
            dp[0][j]=1.0;
        for(int i=1;i<=m;i++)
            for(int j=1;j<=m;j++) {
                for(int[] dir:dirs)
                    dp[i][j]+=dp[Math.max(i+dir[0], 0)][Math.max(j+dir[1], 0)];
                dp[i][j]/=4.0;
            }
        return dp[m][m];
    }
}
