// Using hashmap and sorting
// t.c.=O(nlogn), s.c.=O(n)
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String word : words)
            map.put(word, map.getOrDefault(word, 0)+1);
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (s1, s2)->map.get(s1).equals(map.get(s2))?s1.compareTo(s2):map.get(s2)-map.get(s1));
        return list.subList(0,k);
    }
}

