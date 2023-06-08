// using hashmap
// t.c.=O(n*k), s.c.=O(n*k), where n is the number of strings and k is the max length of a string
class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List> map = new HashMap<>();
        for(String s:strings) {
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<s.length();i++){
                char c=(char)((s.charAt(i)-s.charAt(0)+26)%26+'a');
                sb.append(c);
            }
            String key = sb.toString();
            if(!map.containsKey(key))
                map.put(key, new ArrayList());
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }
}
