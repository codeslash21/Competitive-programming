// using bit masking and hashmap
// t.c.=O(n^2*l), s.c.=O(n), where l is the total length of all words
class Solution {
    public int bitNumber(char ch) {
        return ch-'a';
    }
    public int maxProduct(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();
        int n= words.length, res=0;
        for(int i=0;i<n;i++) {
            int bitMask=0;
            for(char c:words[i].toCharArray()) 
                bitMask |= 1<<bitNumber(c);
            map.put(bitMask,Math.max(map.getOrDefault(bitMask,0),words[i].length()));
        }
        for(int i:map.keySet())
            for(int j:map.keySet())
                if((i&j)==0)
                    res=Math.max(res, map.get(i)*map.get(j));
        return res;
    }
}
