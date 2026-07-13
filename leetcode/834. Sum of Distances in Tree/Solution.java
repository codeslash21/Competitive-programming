// https://leetcode.com/problems/sum-of-distances-in-tree/
// using bfs from each node
// t.c.=O(n^2), s.c.=O(n)
class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        // build the graph
        List<Integer>[] graph=new List[n];
        for(int i=0;i<n;i++)    graph[i]=new ArrayList<>();
        for(int[] edge:edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int[] result=new int[n];
        // apply bfs from each node
        for(int i=0;i<n;i++) {
            Queue<Integer> queue=new LinkedList<>();
            boolean[] visited=new boolean[n];
            int level=0, totalDist=0;
            queue.offer(i);
            visited[i]=true;
            while(!queue.isEmpty()) {
                int levelSize=queue.size();
                while(levelSize-->0) {
                    int node=queue.poll();
                    totalDist+=level;
                    for(int neighbor:graph[node]) 
                        if(!visited[neighbor]) {
                            visited[neighbor]=true;
                            queue.offer(neighbor);
                        }
                }
                level++;
            }
            result[i]=totalDist;
        }
        return result;
    }
}

// using dfs+bfs
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        // build the graph
        List<Integer>[] graph=new List[n];
        for(int i=0;i<n;i++)    graph[i]=new ArrayList<>();
        for(int[] edge:edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        // find the subtree sizes and order of visit
        int[] subtreeSizes=new int[n], parents=new int[n];
        List<Integer> order=new ArrayList<>();
        boolean[] visited=new boolean[n];
        visited[0]=true;
        order.add(0);
        parents[0]=-1;
        findSubtreeSizes(graph, subtreeSizes, parents, order, visited, 0);
        // find total distance from node 0
        int[] totalDists=new int[n];
        totalDists[0]=getTotalDistFromRoot(graph, 0, n);
        // calculate the total distance for other nodes from the total distance of node 0
        for(int i=1;i<n;i++) {
            int node=order.get(i), parent=parents[node];
            int parentTotalDist=totalDists[parent], subtreeSize=subtreeSizes[node];
            totalDists[node]=parentTotalDist+n-2*subtreeSize;
        }
        return totalDists;
    }
    private int findSubtreeSizes(List<Integer>[] graph, int[] subtreeSizes, 
            int[] parents, List<Integer> order, boolean[] visited, int node) {
        int size=1;
        for(int neighbor:graph[node])
            if(!visited[neighbor]) {
                visited[neighbor]=true;
                parents[neighbor]=node;
                order.add(neighbor);
                size+=findSubtreeSizes(graph, subtreeSizes, parents, order, visited, neighbor);
            }
        subtreeSizes[node]=size;
        return subtreeSizes[node];
    }
    private int getTotalDistFromRoot(List<Integer>[] graph, int root, int n) {
        Queue<Integer> queue=new LinkedList<>();
        boolean[] visited=new boolean[n];
        int level=0, totalDist=0;
        queue.offer(root);
        visited[root]=true;
        while(!queue.isEmpty()) {
            int levelSize=queue.size();
            while(levelSize-->0) {
                int node=queue.poll();
                totalDist+=level;
                for(int neighbor:graph[node]) 
                    if(!visited[neighbor]) {
                        visited[neighbor]=true;
                        queue.offer(neighbor);
                    }
            }
            level++;
        }
        return totalDist;
    }
}
