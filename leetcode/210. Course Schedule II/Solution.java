// Using kahn's algorithm
// t.c.=O(m+n), s.c.=O(m+n)
class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        int[] indegree = new int[n], res=new int[n];
        List<Integer>[] adj = new ArrayList[n];
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<n;i++)
            adj[i]=new ArrayList<>();
        for(int[] pre:prerequisites) {
            adj[pre[1]].add(pre[0]);
            indegree[pre[0]]++;
        }
        for(int i=0;i<n;i++)
            if(indegree[i]==0)
                queue.offer(i);
        int visited=0;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            res[visited++]=node;
            for(int nei:adj[node]) {
                indegree[nei]--;
                if(indegree[nei]==0)
                    queue.offer(nei);
            }
        }
        return visited==n?res:new int[0];
    }
}
