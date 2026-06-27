// https://leetcode.com/problems/word-ladder/description/
// using wildcard pattern
// t.c.=O(nm^2), s.c.=O(nm^2), n=total words, m=word len
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len=beginWord.length(), pathLen=1;
        Set<String> visited=new HashSet<>();
        Queue<String> queue=new LinkedList<>();
        // build a wildcard pattern map
        Map<String, List<String>> patternMap=new HashMap<>();
        for(String word:wordList) {
            for(int i=0;i<len;i++) {
                String pattern=word.substring(0,i)+"*"+word.substring(i+1);
                patternMap.computeIfAbsent(pattern, k->new ArrayList<>()).add(word);
            }
        }
        queue.offer(beginWord);
        visited.add(beginWord);
        while(!queue.isEmpty()) {
            int levelSize=queue.size();
            while(levelSize-->0) {
                String word=queue.poll();
                for(int i=0;i<len;i++) {
                    String pattern=word.substring(0,i)+"*"+word.substring(i+1);
                    for(String neighbor:patternMap.getOrDefault(pattern, new ArrayList<>())) {
                        if(neighbor.equals(endWord))    return pathLen+1;
                        if(!visited.contains(neighbor)) {
                            visited.add(neighbor);
                            queue.offer(neighbor);
                        }
                    }
                }
            }
            pathLen++;
        }
        return 0;
    }
}
