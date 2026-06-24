// https://leetcode.com/problems/time-needed-to-inform-all-employees/description/
// using bfs
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> managers=new HashMap<>();
        Queue<int[]> queue=new LinkedList<>();
        int newsTime=0;
        queue.offer(new int[]{headID, 0});
        for(int emp=0;emp<n;emp++)
            if(manager[emp]!=-1)
                managers.computeIfAbsent(manager[emp], k->new ArrayList<>()).add(emp);
        while(!queue.isEmpty()) {
            int[] pair=queue.poll();
            int emp=pair[0], currTime=pair[1];
            if(!managers.containsKey(emp)) {
                newsTime=Math.max(newsTime, currTime);
                continue;
            }
            for(int subordinate:managers.get(emp))
                queue.offer(new int[]{subordinate, currTime+informTime[emp]});
        }
        return newsTime;
    }
}
