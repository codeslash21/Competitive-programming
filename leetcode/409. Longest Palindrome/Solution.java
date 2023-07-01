// Using hashmap
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int oddLen=0, len=0;
        for(int val:map.values()) {
            if(val%2!=0)
                oddLen++;
            len+=val;
        }
        return oddLen>1?len-(oddLen-1):len;
    }
}
