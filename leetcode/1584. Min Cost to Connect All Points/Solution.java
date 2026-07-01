// https://leetcode.com/problems/min-cost-to-connect-all-points/description/
// using Kruskal's algo
// t.c.=O(n^2 * logn), s.c.=O(n^2)
class DSU {
    private int[] parent, rank;
    public DSU(int n) {
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++)    parent[i]=i;
    }
    public int find(int x) {
        if(parent[x]!=x)
            parent[x]=find(parent[x]);
        return parent[x];
    }
    public boolean union(int x, int y) {
        int rootX=find(x), rootY=find(y);
        if(rootX==rootY)    return false;
        if(rank[rootX]>rank[rootY])
            parent[rootY]=rootX;
        else if(rank[rootX]<rank[rootY])
            parent[rootX]=rootY;
        else {
            parent[rootX]=rootY;
            rank[rootY]++;
        }
        return true;
    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int nodes=points.length;
        DSU dsu=new DSU(nodes);
        List<int[]> edges=new ArrayList<>();
        for(int i=0;i<nodes;i++) {
            for(int j=i+1;j<nodes;j++) {
                int dist=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                edges.add(new int[]{dist, i, j});
            }
        }
        Collections.sort(edges, (a,b)->a[0]-b[0]);
        int includedEdges=0, minCost=0;
        for(int[] edge:edges) {
            if(dsu.union(edge[1], edge[2])) {
                includedEdges++;
                minCost+=edge[0];
            }
            if(includedEdges==(nodes-1))   break;
        }
        return minCost;
    }
}

// using prims algorithm
// t.c.=O(n^2logn), s.c.=O(n^2)
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int nodes=points.length;
        PriorityQueue<int[]> minHeap=new PriorityQueue<>((a,b)->a[0]-b[0]);
        boolean[] visited=new boolean[nodes];
        int totalCost=0, nodesUsed=1;
        visited[0]=true;
        for(int i=1;i<nodes;i++) {
            int cost=Math.abs(points[0][0]-points[i][0])+Math.abs(points[0][1]-points[i][1]);
            minHeap.offer(new int[]{cost, i});
        }
        while(nodesUsed<nodes) {
            int[] edge=minHeap.poll();
            int cost=edge[0], node=edge[1];
            if(visited[node])   continue;
            visited[node]=true;
            totalCost+=cost;
            nodesUsed++;
            for(int i=0;i<nodes;i++) {
                if(visited[i])  continue;
                int newCost=Math.abs(points[i][0]-points[node][0])+Math.abs(points[i][1]-points[node][1]);
                minHeap.offer(new int[]{newCost, i});
            }
        }
        return totalCost;
    }
}

// using Prims' algo without using heap
// t.c.=O(n^2), s.c.=O(n^2)
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int nodes=points.length;
        int[] minDist=new int[nodes];
        int totalCost=0;
        for(int i=1;i<nodes;i++)
            minDist[i]=Math.abs(points[0][0]-points[i][0])+Math.abs(points[0][1]-points[i][1]);
        minDist[0]=-1;  // mark node 0 as visited
        // chose the remaining nodes-1 nodes
        for(int i=0;i<nodes-1;i++) {
            // find the node with smallest distance
            int minCostNode=-1;
            for(int j=0;j<nodes;j++)
                if(minDist[j]>=0 && (minCostNode==-1 || minDist[j]<minDist[minCostNode]))
                    minCostNode=j;
            // add the node with smallest distance
            totalCost+=minDist[minCostNode];
            minDist[minCostNode]=-1;
            // update minDist for remaining unvisited nodes
            for(int v=0;v<nodes;v++) {
                if(minDist[v]<0)    continue;
                int dist=Math.abs(points[v][0]-points[minCostNode][0])+Math.abs(points[v][1]-points[minCostNode][1]);
                minDist[v]=Math.min(minDist[v], dist);
            }
        }
        return totalCost;
    }
}
