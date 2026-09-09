// https://leetcode.com/problems/frog-jump/description/
// using top-down dp
// t.c.=O(n^2), s.c.=O(n^2)
class Solution {
    int[][] dp;
    Map<Integer, Integer> positions;
    private boolean dfs(int[] stones, int index, int lastJump) {
        if(index==stones.length-1)   return true;
        if(dp[index][lastJump]!=-1)
            return dp[index][lastJump]==1;
        boolean ans=false;
        for(int nextJump=lastJump-1;nextJump<=lastJump+1;nextJump++) {
            int nextPosition=stones[index]+nextJump;
            if(nextJump>0 && positions.containsKey(nextPosition))
                ans = ans || dfs(stones, positions.get(nextPosition), nextJump);
        }
        dp[index][lastJump]=ans?1:0;
        return ans;
    }
    public boolean canCross(int[] stones) {
        int len=stones.length;
        dp=new int[len][len];
        positions=new HashMap<>();
        for(int i=0;i<len;i++)
            Arrays.fill(dp[i], -1);
        for(int i=0;i<len;i++)
            positions.put(stones[i], i);
        return dfs(stones, 0, 0);
    }
}
