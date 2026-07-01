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
