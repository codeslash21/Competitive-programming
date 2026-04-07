// https://leetcode.com/problems/split-array-into-consecutive-subsequences/description/
// using greedy + hashmap
// t.c.=O(n), s.c.=O(n)
class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>(), tail=new HashMap<>();
        for (int num : nums) 
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        for(int num:nums) {
            if(freq.getOrDefault(num, 0)==0)
                continue;
            if(tail.getOrDefault(num, 0)>0) {
                tail.put(num, tail.get(num)-1);
                tail.put(num+1, tail.getOrDefault(num+1, 0)+1);
            } else if(freq.getOrDefault(num+1, 0)>0 && freq.getOrDefault(num+2, 0)>0) {
                freq.put(num+1, freq.get(num+1)-1);
                freq.put(num+2, freq.get(num+2)-1);
                tail.put(num+3, tail.getOrDefault(num+3, 0)+1);
            } else
                return false;
            freq.put(num, freq.get(num)-1);
        }
        return true;
    }
}
