// https://leetcode.com/problems/number-of-good-ways-to-split-a-string/description/
// using hashmap
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int numSplits(String s) {
        int len=s.length(), count=0, idx=0;
        Map<Character, Integer> leftMap=new HashMap<>(), rightMap=new HashMap<>();
        for(char ch:s.toCharArray())
            rightMap.put(ch, rightMap.getOrDefault(ch, 0)+1);
        while(leftMap.size()<=rightMap.size() && idx<len) {
            if(leftMap.size()==rightMap.size())
                count++;
            char ch=s.charAt(idx++);
            leftMap.put(ch, leftMap.getOrDefault(ch, 0)+1);
            rightMap.put(ch, rightMap.get(ch)-1);
            if(rightMap.get(ch)==0)
                rightMap.remove(ch);
        }
        return count;
    }
}
