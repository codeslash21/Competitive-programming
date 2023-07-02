// Using bfs
// s.c.=O(V+E), s.c.=O(V+E)
class Solution {
    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer>[] adj = new ArrayList[n];
        int components=0;
        for(int i=0;i<n;i++)
            adj[i]=new ArrayList<>();
        for(int[] edge:edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                queue.offer(i);
                components++;
                while(!queue.isEmpty()) {
                    int node = queue.poll();
                    visited[node]=true;
                    for(int nei:adj[node])
                        if(!visited[nei])
                            queue.offer(nei);
                }
            }
        }
        return components;
    }
}
