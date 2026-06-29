// https://leetcode.com/problems/alien-dictionary/description/
// using topological sort (Kahn's algo)
// t.c.=O(n), s.c.=O(n), n=total number of characters
class Solution {
    public String alienOrder(String[] words) {
        Set<Character> alphabets=new HashSet<>();
        Map<Character, List<Character>> graph=new HashMap<>();
        StringBuilder sb=new StringBuilder();
        Queue<Character> queue=new LinkedList<>();
        int[] indegrees=new int[26];
        int processed=0;
        for(char ch:words[0].toCharArray())
            alphabets.add(ch);
        for(int i=1;i<words.length;i++) {
            String prev=words[i-1], curr=words[i]; 
            int len=Math.min(prev.length(), curr.length()), idx=0;
            while(idx<len && prev.charAt(idx)==curr.charAt(idx))
                idx++;
            if(idx==len && prev.length()>len)   return "";
            if(idx<len) {
                graph.computeIfAbsent(prev.charAt(idx), k->new ArrayList<>()).add(curr.charAt(idx));
                indegrees[curr.charAt(idx)-'a']++;
            }
            while(idx<curr.length())
                alphabets.add(curr.charAt(idx++));
        }
        for(char ch:alphabets)
            if(indegrees[ch-'a']==0)    queue.offer(ch);
        while(!queue.isEmpty()) {
            char ch=queue.poll();
            sb.append(ch);
            processed++;
            for(char next:graph.getOrDefault(ch, new ArrayList<>())) {
                indegrees[next-'a']--;
                if(indegrees[next-'a']==0)
                    queue.offer(next);
            }
        }
        return processed==alphabets.size()?sb.toString():"";
    }
}
