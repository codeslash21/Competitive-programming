// https://leetcode.com/problems/find-eventual-safe-states/description/
// using dfs with coloring
// t.c.=O(V+E), s.c.=O(V)
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int nodes=graph.length;
        int[] colors=new int[nodes];
        List<Integer> result=new ArrayList<>();
        for(int node=0;node<nodes;node++)
            if(dfs(graph, node, colors))
                result.add(node);
        return result;
    }
    private boolean dfs(int[][] graph, int node, int[] colors) {
        if(colors[node]==1)  return false;
        if(colors[node]!=0)  return colors[node]==2;
        colors[node]=1;  // mark as visited
        for(int neighbor:graph[node])
            if(!dfs(graph, neighbor, colors)) {
                colors[node]=3;
                return false;
            }
        colors[node]=2;
        return true;
    }
}

// using Kahn's algo
// t.c.=O(V+E), s.c.=O(V+E)
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int nodes=graph.length;
        int[] outdegrees=new int[nodes];
        Map<Integer, List<Integer>> predecessors=new HashMap<>();
        Queue<Integer> queue=new LinkedList<>();
        List<Integer> result=new ArrayList<>();
        for(int node=0;node<nodes;node++) {
            outdegrees[node]=graph[node].length;
            for(int neighbor:graph[node])
                predecessors.computeIfAbsent(neighbor, k->new ArrayList<>()).add(node);
        }
        for(int node=0;node<nodes;node++)
            if(outdegrees[node]==0)
                queue.offer(node);
        while(!queue.isEmpty()) {
            int node=queue.poll();
            for(int predecessor:predecessors.getOrDefault(node, new ArrayList<>())) {
                outdegrees[predecessor]--;
                if(outdegrees[predecessor]==0)  queue.offer(predecessor);
            }
        }
        for(int node=0;node<nodes;node++)
            if(outdegrees[node]==0) result.add(node);
        return result;
    }
}
