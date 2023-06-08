// using hashmap and heap
// t.c.=O(n+klogk), s.c.=O(k), k is the number of unique characters
class Solution {
    public String frequencySort(String s) {
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        for(char c:s.toCharArray())
            map.put(c, map.getOrDefault(c, 0)+1);
        maxHeap.addAll(map.keySet());
        StringBuilder sb = new StringBuilder();
        while(!maxHeap.isEmpty()) {
            char c = maxHeap.poll();
            for(int i=0;i<map.get(c);i++)
                sb.append(c);
        }
        return sb.toString();
    }
}

// Using bucket sort
// t.c.=O(n), s.c.=O(n)
class Solution {
    public String frequencySort(String s) {
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for(char c:s.toCharArray())
            map.put(c, map.getOrDefault(c, 0)+1);
        int maxFreq = Collections.max(map.values());
        List<List<Character>> bucket = new ArrayList<>();
        for(int i=0;i<=maxFreq;i++)
            bucket.add(new ArrayList());
        for(char c:map.keySet())
            bucket.get(map.get(c)).add(c);
        StringBuilder sb = new StringBuilder();
        for(int i=maxFreq;i>0;i--)
            for(Character c:bucket.get(i))
                for(int j=0;j<i;j++)
                    sb.append(c);
        return sb.toString();
    }
}
