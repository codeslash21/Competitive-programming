// https://leetcode.com/problems/burst-balloons/
// using recursion
// t.c.=O(n*2^n), s.c.=O(n^2)
class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n+2];
        arr[0]=arr[n+1]=1;
        for(int i=0;i<n;i++)
            arr[i+1]=nums[i];
        return dfs(arr);
    }
    private int dfs(int[] nums) {
        if(nums.length==2)  return 0;
        int maxCoins=0;
        for(int i=1;i<nums.length-1;i++) {
            int coins=nums[i-1]*nums[i]*nums[i+1];
            int[] newArr=new int[nums.length-1];
            for(int j=0,k=0;j<nums.length;j++)
                if(j!=i)
                    newArr[k++]=nums[j];
            coins+=dfs(newArr);
            maxCoins=Math.max(maxCoins, coins);
        }
        return maxCoins;
    }
}

// using dp
// t.c.=O(n^3), s.c.=O(n^2)
class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[] newArr=new int[n+2];
        int[][] dp=new int[n+2][n+2];
        newArr[0]=newArr[n+1]=1;
        for(int i=0;i<n;i++)
            newArr[i+1]=nums[i];
        for(int l=n;l>0;l--)
            for(int r=l;r<=n;r++)
                for(int i=l;i<=r;i++) {
                    int coins=newArr[l-1]*newArr[i]*newArr[r+1];
                    coins+=dp[l][i-1]+dp[i+1][r];
                    dp[l][r]=Math.max(dp[l][r], coins);
                }
        return dp[1][n];
    }
}
