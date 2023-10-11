// Using dfs
// t.c.=O(V+E), s.c.+O(V+E)
public class Solution {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        Map<Integer, List<Integer>> graph  = new HashMap<>();
        for(ArrayList<Integer> edge:B) {
            int a=edge.get(0), b=edge.get(1);
            graph.computeIfAbsent(a, val->new ArrayList<Integer>()).add(b);
        }
        boolean[] seen = new boolean[A+1];
        seen[1]=true;
        if(!graph.containsKey(1))
            return 0;
        return dfs(graph, seen, 1, A)?1:0;
    }
    private boolean dfs(Map<Integer, List<Integer>> graph, boolean[] seen, int curr, int A) {
        if(curr==A)
            return true;
        if(!graph.containsKey(curr))
            return false;
        for(int nei:graph.get(curr)) {
            if(!seen[nei]) {
                seen[nei]=true;
                if(dfs(graph, seen, nei, A))
                    return true;
            }
        }
        return false;
    }
}
