// Using set
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums)
            set.add(num);
        int res=0;
        for(int num:nums) {
            if(!set.contains(num-1)) {
                int curr = num;
                int currStreak = 1;
                while(set.contains(curr+1)) {
                    curr+=1;
                    currStreak+=1;
                }
                res = Math.max(res, currStreak);
            }
        }
        return res;
    }
}
