// https://leetcode.com/problems/fruit-into-baskets/description/
// sliding window
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int totalFruit(int[] fruits) {
        int len=fruits.length, left=0, right=0, maxFruits=0;
        Map<Integer, Integer> map=new HashMap<>();
        while(right<len) {
            map.put(fruits[right], right++);
            if(map.size()>2) {
                int idx=Collections.min(map.values());
                map.remove(fruits[idx]);
                left=idx+1;
            }
            maxFruits=Math.max(maxFruits, right-left);
        }
        return maxFruits;
    }
}
