// https://leetcode.com/problems/minimum-height-trees/description/
// using topological sort (leaf trimming)
// t.c.=O(n), s.c.=O(n)
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1)    return List.of(0);
        if(n==2)    return List.of(0, 1);
        int[] indegrees=new int[n];
        List<List<Integer>> adjList=new ArrayList<>();
        Queue<Integer> leaves=new LinkedList<>();
        int remainingNodes=n;
        for(int node=0;node<n;node++)   adjList.add(new ArrayList<>());
        for(int[] edge:edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
            indegrees[edge[0]]++;
            indegrees[edge[1]]++;
        }
        for(int node=0;node<n;node++)
            if(indegrees[node]==1)
                leaves.offer(node);
        while(remainingNodes>2) {
            int leafCounts=leaves.size();
            remainingNodes-=leafCounts;
            while(leafCounts-->0) {
                int leaf=leaves.poll();
                for(int neighbor:adjList.get(leaf)) {
                    indegrees[neighbor]--;
                    if(indegrees[neighbor]==1)  leaves.offer(neighbor);
                }
            }
        }
        return new ArrayList<>(leaves);
    }
}
