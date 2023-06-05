// Using map
// t.c.=O(n), s.c.=O(1)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> mapp = new HashMap<>();
        Map<Character, Integer> maps = new HashMap<>();
        int lenp=p.length(), lens=s.length(), i=0, start=0, seen=0;
        List<Integer> res = new ArrayList<>();
        if(lenp>lens)
            return res;
        for(char c:p.toCharArray())
            mapp.put(c, mapp.getOrDefault(c, 0)+1);
        for(i=0;i<lenp-1;i++){
            char c = s.charAt(i);
            maps.put(c, maps.getOrDefault(c, 0)+1);
            if(mapp.containsKey(c) && mapp.get(c)>=maps.get(c))
                seen++;
        }
        while(i<lens) {
            char c = s.charAt(i);
            maps.put(c, maps.getOrDefault(c, 0)+1);
            if(mapp.containsKey(c) && mapp.get(c)>=maps.get(c))
                seen++;
            if(seen==lenp)
                res.add(start);
            c = s.charAt(start);
            maps.put(c, maps.get(c)-1);
            if(mapp.containsKey(c) && mapp.get(c)>maps.get(c))
                seen--;
            start++;
            i++;
        }
        return res;
    }
}
