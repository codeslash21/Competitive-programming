// https://leetcode.com/problems/jump-game-ii/description/
// using dp
// t.c.=O(n^2), s.c.=O(n)
class Solution {
    public int jump(int[] nums) {
        int len=nums.length;
        int[] dp=new int[len];
        for(int i=1;i<len;i++)
            dp[i]=Integer.MAX_VALUE;
        for(int i=1;i<len;i++)
            for(int j=0;j<i;j++)
                if(j+nums[j]>=i)
                    dp[i]=Math.min(dp[i], dp[j]+1);
        return dp[len-1];
    }
}

// using bfs
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int jump(int[] nums) {
        int currEnd=0, jumps=0, furthest=0, len=nums.length;
        for(int i=0;i<len-1;i++) {
            furthest=Math.max(furthest, i+nums[i]);
            if(currEnd==i) {
                jumps++;
                currEnd=furthest;
            }
            if(currEnd>=len-1)
                break;
        }
        return jumps;
    }
}
