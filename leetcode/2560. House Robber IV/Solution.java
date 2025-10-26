// https://leetcode.com/problems/house-robber-iv/description/
// t.c.=O(nlogn), s.c.=O(1)
class Solution {
    public int minCapability(int[] nums, int k) {
        int totalHouses=nums.length, minReward=1, maxReward=Arrays.stream(nums).max().getAsInt();
        while(minReward<maxReward) {
            int midReward=minReward+(maxReward-minReward)/2, possibleThefts=0;
            for(int i=0;i<totalHouses;i++) 
                if(nums[i]<=midReward) {
                    possibleThefts++;
                    i++;
                }
            if(possibleThefts>=k)
                maxReward=midReward;
            else
                minReward=midReward+1;
        }
        return maxReward;
    }
}
