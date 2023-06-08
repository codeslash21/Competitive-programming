// Using heap and map
// t.c.=O(nlogn), s.c.=O(n)
class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        int n=s.length();
        for(int i=0;i<n;i++)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        maxHeap.addAll(map.keySet());
        StringBuilder sb = new StringBuilder();
        while(maxHeap.size()>1) {
            char first = maxHeap.poll();
            char second = maxHeap.poll();
            sb.append(first);
            sb.append(second);
            map.put(first, map.get(first)-1);
            map.put(second, map.get(second)-1);
            if(map.get(first)>0)
                maxHeap.offer(first);
            if(map.get(second)>0)
                maxHeap.offer(second);
        }
        if(!maxHeap.isEmpty()) {
            if(map.get(maxHeap.peek())>1)
                return "";
            else
                sb.append(maxHeap.poll());
        }
        return sb.toString();
    }
}
