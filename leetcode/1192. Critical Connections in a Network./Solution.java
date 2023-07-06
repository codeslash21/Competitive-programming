// Using dfs
// t..c.=O(V+E), s.c.=O(V+E)
class Solution {
    private Map<Integer, Integer> rank;
    private Map<Integer, List<Integer>> graph;
    private Map<Pair<Integer, Integer>, Boolean> connDict;
    public void formGraph(int n, List<List<Integer>> edges) {
        graph = new HashMap<>();
        rank = new HashMap<>();
        connDict = new HashMap<>();
        for(int i=0;i<n;i++) {
            graph.put(i, new ArrayList<>());
            rank.put(i, null);
        }
        for(List<Integer> edge:edges) {
            int u=edge.get(0), v=edge.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
            int sortedU = Math.min(u,v), sortedV=Math.max(u,v);
            connDict.put(new Pair<Integer, Integer>(sortedU, sortedV), true);
        }
    }
    public int dfs(int node, int discoveryRank) {
        if(rank.get(node)!=null)
            return rank.get(node);
        rank.put(node, discoveryRank);
        int minRank=discoveryRank + 1;
        for(Integer nei:graph.get(node)) {
            Integer neiRank=rank.get(nei);
            if(neiRank!=null && neiRank==discoveryRank-1)
                continue;
            int recursiveRank=dfs(nei, discoveryRank+1);
            if(recursiveRank<=discoveryRank) {
                int sortedU = Math.min(node, nei), sortedV=Math.max(node, nei);
                connDict.remove(new Pair<Integer, Integer>(sortedU, sortedV));
            }
            minRank = Math.min(minRank, recursiveRank);
        }
        return minRank;
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        formGraph(n, connections);
        dfs(0,0);
        List<List<Integer>> results = new ArrayList<>();
        for(Pair<Integer, Integer> edge:connDict.keySet())
            results.add(new ArrayList<Integer>(Arrays.asList(edge.getKey(), edge.getValue())));
        return results;
    }
}
