// using bfs
// t.c.=O(V+E), s.c.=O(V+E)
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge:edges) {
            int a=edge[0], b=edge[1];
            graph.computeIfAbsent(a, val->new ArrayList<Integer>()).add(b);
            graph.computeIfAbsent(b, val->new ArrayList<Integer>()).add(a);
        }
        boolean[] seen = new boolean[n];
        seen[source]=true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            if(curr==destination)
                return true;
            for(int nei:graph.get(curr)) {
                if(!seen[nei]) {
                    seen[nei]=true;
                    queue.offer(nei);
                }
            }
        }
        return false;
    }
}

// using dfs
// t.c.=O(V+E), s.c.=O(V+E)
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge:edges) {
            int a=edge[0], b=edge[1];
            graph.computeIfAbsent(a, val->new ArrayList<Integer>()).add(b);
            graph.computeIfAbsent(b, val->new ArrayList<Integer>()).add(a);
        }
        boolean[] seen = new boolean[n];
        return dfs(graph, seen, source, destination);
    }
    private boolean dfs(Map<Integer, List<Integer>> graph, boolean[] seen, int curr, int dest) {
        if(curr==dest)
            return true;
        if(!seen[curr]) {
            seen[curr]=true;
            for(int nei:graph.get(curr)) {
                if(dfs(graph, seen, nei, dest))
                    return true;
            }
        }
        return false;
    }
}
