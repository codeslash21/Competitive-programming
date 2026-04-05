// https://leetcode.com/problems/number-of-good-pairs/description/
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map=new HashMap<>();
        int res=0;
        for(int num:nums) {
            res+=map.getOrDefault(num, 0);
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        return res;
    }
}
