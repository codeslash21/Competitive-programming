// Using sliding window
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l=0, r=0;
        int max=0;
        int required=2;
        while(r<s.length()) {
            map.put(s.charAt(r), r++);
            if(map.size()>required) {
                int idx_val=Collections.min(map.values());
                map.remove(s.charAt(idx_val));
                l=idx_val+1;
            }
            max=Math.max(max, r-l);
        }
        return max;
    }
}
