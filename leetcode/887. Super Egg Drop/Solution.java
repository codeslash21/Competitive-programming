// Using dp iterative approach
// t.c.=O(k*n^2), s.c.=O(k*n)
class Solution {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k+1][n+1];
        for(int i=0; i<=n; i++){
            dp[0][i]=n+2;
            dp[1][i]=i;
        }
        for(int i=1;i<=k;i++){
            dp[i][0]=0;
            dp[i][1]=1;
        }
        for(int i=2;i<=k;i++)
            for(int j=2;j<=n;j++) {
                dp[i][j]=n+2;
                for(int x=1;x<=j;x++)
                    dp[i][j]=Math.min(dp[i][j], 1+Math.max(dp[i-1][x-1], dp[i][j-x]));
            }
        return dp[k][n];
    }
}

// Using binary search
// t.c.=O(k*n*logn), s.c.=O(k*n)
class Solution {
    Map<Integer, Integer> map = new HashMap();
    public int dp(int k, int n) {
        int key=n*100+k;
        if(map.containsKey(key)) 
            return map.get(key);
        int ans;
        if(n==0)
            ans = 0;
        else if(k==1)
            ans = n;
        else {
            int lo=1, hi=n;
            while(lo<hi) {
                int x=(lo+hi)/2;
                int t1=dp(k-1, x-1);
                int t2=dp(k, n-x);
                if(t1<t2)
                    lo=x+1;
                else if(t1>t2)
                    hi=x-1;
                else
                    lo=hi=x;
            }
            ans = 1 + Math.max(dp(k-1,lo-1), dp(k,n-lo));
        }
        map.put(key, ans);
        return map.get(key);
    }
    public int superEggDrop(int k, int n) {
        return dp(k, n);
    }
}
