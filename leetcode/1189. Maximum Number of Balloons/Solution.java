// https://leetcode.com/problems/maximum-number-of-balloons/description/
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int maxNumberOfBalloons(String text) {
        int res=Integer.MAX_VALUE;
        Map<Character, Integer> map=new HashMap<>(Map.of(
            'b', 0,
            'a', 0,
            'l', 0,
            'o', 0,
            'n', 0
        ));
        for(char ch:text.toCharArray())
            if(map.containsKey(ch))
                map.put(ch, map.getOrDefault(ch, 0)+1);
        for(Map.Entry<Character, Integer> entry:map.entrySet()) 
            if(entry.getKey()=='l' || entry.getKey()=='o')
                res=Math.min(res, entry.getValue()/2);
            else
                res=Math.min(res, entry.getValue());
        return res;
    }
}
