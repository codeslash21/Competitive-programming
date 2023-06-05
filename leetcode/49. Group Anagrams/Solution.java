// Using sorting
// t.c.=O(nklogk), s.c.=O(nk)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0)
            return new ArrayList();
        Map<String, List> map = new HashMap<>();
        for(String str:strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String s = String.valueOf(ch);
            if(!map.containsKey(s))
                map.put(s, new ArrayList());
            map.get(s).add(str);
        }
        return new ArrayList(map.values());
    }
}

