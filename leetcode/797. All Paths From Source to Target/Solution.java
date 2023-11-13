// Using backtracking
// t.c.=O(2^n * n), as there are max 2^(n-1)-1 paths possible between 0 and (n-1) node and to make each path we need O(n) time. s.c.=O(n)
class Solution {
    int target;
    int[][] graph;
    List<List<Integer>> res;
    private void backtrack(int curr, LinkedList<Integer> path) {
        if(curr==target) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for(int nei:graph[curr]) {
            path.addLast(nei);
            backtrack(nei, path);
            path.removeLast();
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.graph=graph;
        target=graph.length-1;
        res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        path.addLast(0);
        backtrack(0, path);
        return res;
    }
}
