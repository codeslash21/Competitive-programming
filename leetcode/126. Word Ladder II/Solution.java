// https://leetcode.com/problems/word-ladder-ii/description/
// using hashmap and dfs
// t.c.=O(m*n^2), s.c.=O(m*n^2), m=len(wordList), n=len(beginWord)
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int level=1, shortestPathLen=Integer.MAX_VALUE, len=beginWord.length();
        List<List<String>> shortestPaths=new ArrayList<>();
        Queue<List<String>> queue=new LinkedList<>();
        List<String> visited=new ArrayList<>();
        Set<String> wordSet=new HashSet<>(wordList);
        Map<String, List<String>> patternMap=new HashMap<>();
        for(String word:wordList) {
            for(int i=0;i<len;i++) {
                String pattern=word.substring(0, i)+"*"+word.substring(i+1, len);
                patternMap.computeIfAbsent(pattern, k->new ArrayList<>()).add(word);
            }
        }
        queue.offer(new ArrayList<>(List.of(beginWord)));
        while(!queue.isEmpty()) {
            int levelSize=queue.size();
            level++;
            while(levelSize-->0) {
                List<String> path=queue.poll();
                // no need to explore paths that are longer than our shortest path
                if(path.size()>shortestPathLen) {
                    queue.clear();
                    break;
                }
                String lastNode=path.get(path.size()-1);
                for(int i=0;i<len;i++) {
                    String pattern=lastNode.substring(0, i)+"*"+lastNode.substring(i+1, len);
                    for(String nextNode:patternMap.getOrDefault(pattern, new ArrayList<>())) {
                        if(!wordSet.contains(nextNode))
                            continue;
                        // create the new path
                        List<String> newPath=new ArrayList<>(path);
                        newPath.add(nextNode);
                        visited.add(nextNode);
                        if(nextNode.equals(endWord)) {
                            shortestPathLen=level;
                            shortestPaths.add(newPath);
                        } else
                            queue.offer(newPath);
                    }
                }
            }
            // as we processed the level, remove the nodes from the current level
            for(String word:visited)
                wordSet.remove(word);
            visited.clear();
        }
        return shortestPaths;
    }
}
