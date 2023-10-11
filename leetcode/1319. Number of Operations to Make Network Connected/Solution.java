// using dfs
// t.c.=O(V+E), s.c.=O(V+E)
class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1)
            return -1;
        int com=0;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] seen = new boolean[n];
        for(int[] edge:connections) {
            int a=edge[0], b=edge[1];
            graph.computeIfAbsent(a, val->new ArrayList<>()).add(b);
            graph.computeIfAbsent(b, val->new ArrayList<>()).add(a);
        }
        for(int i=0;i<n;i++) 
            if(!seen[i]) {
                dfs(graph, seen, i);
                com++;
            }
        return com-1;
    }
    private void dfs(Map<Integer, List<Integer>> graph, boolean[] seen, int idx) {
        seen[idx]=true;
        if(!graph.containsKey(idx))
            return;
        for(int nei:graph.get(idx)) 
            if(!seen[nei]) 
                dfs(graph, seen, nei);
    }
}
