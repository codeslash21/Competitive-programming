// https://leetcode.com/problems/matchsticks-to-square/
// using backtracking
class Solution {
    public boolean makesquare(int[] matchsticks) {
        int[] sums=new int[4];
        Arrays.sort(matchsticks);
        int totalSum = Arrays.stream(matchsticks).sum();
        if(totalSum%4!=0)   return false;
        int targetSum=totalSum/4;
        return backtrack(matchsticks, matchsticks.length-1, targetSum, sums);
    }
    private boolean backtrack(int[] matchsticks, int start, int targetSum, int[] sums) {
        if(start<0) 
            return sums[0]==sums[1] && sums[1]==sums[2] && sums[2]==sums[3];
        for(int i=0;i<4;i++) {
            if(sums[i]+matchsticks[start]<=targetSum) {
                sums[i]+=matchsticks[start];
                if(backtrack(matchsticks, start-1, targetSum, sums))
                    return true;
                sums[i]-=matchsticks[start];
            }
        }
        return false;
    }
}
