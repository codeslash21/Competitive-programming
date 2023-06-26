// Using dfs
// t.c.=O(n^2), s.c.=O(n)
class Solution {
    Set<Integer> seen = new HashSet<>();
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length+1;
        List<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++)
            graph[i] = new ArrayList();
        for(int[] edge:edges) {
            seen.clear();
            if(!graph[edge[0]].isEmpty() && !graph[edge[1]].isEmpty() && dfs(graph, edge[0], edge[1]))
            return edge;
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        return new int[] {0, 0};
    }
    public boolean dfs(List<Integer>[] graph, int source, int target) {
        if(!seen.contains(source)) {
            seen.add(source);
            if(source==target)
                return true;
            for(int nei:graph[source])
                if(dfs(graph, nei, target))
                    return true;
        }
        return false;
    }
}
