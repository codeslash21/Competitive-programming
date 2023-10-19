// Using bfs
// t.c.=O(n), s.c.=O(n)
class Solution {
    Map<Integer, List<Integer>> adj = new HashMap<>();
    private int dfs(int node, int parent, List<Boolean> hasApple) {
        if(!adj.containsKey(node))
            return 0;
        int totalTime=0, childTime=0;
        for(int child:adj.get(node)) {
            if(child==parent)
                continue;
            childTime=dfs(child, node, hasApple);
            if(childTime>0 || hasApple.get(child))
                totalTime+=childTime+2;
        }
        return totalTime;
    }
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        for(int[] edge:edges) {
            int src=edge[0], dest=edge[1];
            adj.computeIfAbsent(src, val-> new ArrayList<>()).add(dest);
            adj.computeIfAbsent(dest, val-> new ArrayList<>()).add(src);
        }
        return dfs(0, -1, hasApple);
    }
}
