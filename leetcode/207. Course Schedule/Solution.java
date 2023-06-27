// using topological sorting
// t.c.=O(m+n), s.c.=O(m+n), where m is number of edges and n is number of nodes
class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        int[] indegree = new int[n];
        List<Integer>[] adj = new ArrayList[n];
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<n; i++)
            adj[i] = new ArrayList<>();
        for(int[] pre : prerequisites) {
            adj[pre[1]].add(pre[0]);
            indegree[pre[0]]++;
        }
        for(int i=0; i<n; i++)
            if(indegree[i]==0)
                queue.offer(i);
        int visited=0;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            visited++;
            for(int nei:adj[node]) {
                indegree[nei]--;
                if(indegree[nei]==0)
                    queue.offer(nei);
            }
        }
        return visited==n;
    }
}

// using dfs
// t.c.=O(m+n), s.c.=O(m+n)
class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<Integer>[] adj = new ArrayList[n];
        boolean[] visit = new boolean[n];
        boolean[] inStack = new boolean[n];
        for(int i=0; i<n; i++)
            adj[i] = new ArrayList<>();
        for(int[] pre : prerequisites)
            adj[pre[1]].add(pre[0]);
        for(int i=0; i<n; i++)
            if(dfs(i, adj, visit, inStack))
                return false;
        return true;
    }
    public boolean dfs(int node, List<Integer>[] adj, boolean[] visit, boolean[] inStack) {
        if(inStack[node])
            return true;
        if(visit[node])
            return false;
        visit[node]=true;
        inStack[node]=true;
        for(int nei:adj[node])
            if(dfs(nei, adj, visit, inStack))
                return true;
        inStack[node]=false;
        return false;
    }
}

