// https://leetcode.com/problems/shortest-path-visiting-all-nodes/description/
// using bfs
// t.c.=O(n*2^n), s.c.=O(n*2^n)
class Solution {
    public int shortestPathLength(int[][] graph) {
        int n=graph.length, distance=0;
        if(n==1)    return distance;
        int fullMask=(1<<n)-1;
        boolean[][] visited=new boolean[n][1<<n];
        Queue<int[]> queue=new LinkedList<>();
        // seed bfs with all possible starting points
        for(int i=0;i<n;i++) {
            int mask=1<<i;
            visited[i][mask]=true;
            queue.offer(new int[]{i, mask});
        }
        while(!queue.isEmpty()) {
            int levelSize=queue.size();
            while(levelSize-->0) {
                int[] state=queue.poll();
                int node=state[0], mask=state[1];
                if(mask==fullMask)  return distance;
                for(int neighbor:graph[node]) {
                    int newMask=mask | 1<<neighbor;
                    if(!visited[neighbor][newMask]) {
                        queue.offer(new int[]{neighbor, newMask});
                        visited[neighbor][newMask]=true;
                    }
                }
            }
            distance++;
        }
        return -1;
    }
}
