// Using set
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet=new HashSet<>();
        int longestStreak=0;
        for(int num:nums)
            numSet.add(num);
        for(int num:numSet)
            if(!numSet.contains(num-1)) {
                int currentStreak=1, nextRequiredNum=num+1;
                while(numSet.contains(nextRequiredNum)) {
                    currentStreak++;
                    nextRequiredNum++;
                }
                longestStreak=Math.max(longestStreak, currentStreak);
            }
        return longestStreak;
    }
}
