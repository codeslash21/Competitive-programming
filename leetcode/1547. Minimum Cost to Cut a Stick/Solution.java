// using dp recursive approach
// t.c.=O(m^2), s.c.=O(m^2)
class Solution {
    int[][] memo;
    int[] new_cuts;
    public int cost(int left, int right) {
        if(memo[left][right]!=0)
            return memo[left][right];
        if(right-left==1)
            return 0;
        int ans = Integer.MAX_VALUE;
        for(int mid=left+1; mid<right; mid++) {
            int cost = cost(left,mid)+cost(mid,right)+new_cuts[right]-new_cuts[left];
            ans=Math.min(ans, cost);
        }
        memo[left][right]=ans;
        return ans;
    }
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        new_cuts = new int[m+2];
        new_cuts[0]=0; new_cuts[m+1]=n;
        for(int i=0;i<m;i++)
            new_cuts[i+1]=cuts[i];
        Arrays.sort(new_cuts);
        memo = new int[m+2][m+2];
        return cost(0, m+1);
    }
}
