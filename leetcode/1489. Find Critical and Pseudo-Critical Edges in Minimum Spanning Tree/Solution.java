// https://leetcode.com/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree/description/
// using Kruskal's algo
// t.c.=O(E^2 * alpha(n)), s.c.=O(E+n)
class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int e=edges.length;
        List<Integer> critical=new ArrayList<>(), pseudoCritical=new ArrayList<>();
        List<List<Integer>> result=new ArrayList<>();
        int[][] indexedEdges=new int[e][4];
        for(int i=0;i<e;i++) {
            indexedEdges[i]=new int[]{edges[i][0], edges[i][1], edges[i][2], i};
        }
        Arrays.sort(indexedEdges, (a,b)->a[2]-b[2]);
        int baselineWeight=buildMST(n, indexedEdges, -1, -1);
        for(int i=0;i<e;i++) {
            int weightWithout=buildMST(n, indexedEdges, -1, i);
            if(weightWithout>baselineWeight)
                critical.add(indexedEdges[i][3]);
            else {
                int weightWith=buildMST(n, indexedEdges, i, -1);
                if(weightWith==baselineWeight)
                    pseudoCritical.add(indexedEdges[i][3]);
            }
        }
        result.add(critical);
        result.add(pseudoCritical);
        return result;
    }
    private int buildMST(int n, int[][] edges, int includeIdx, int excludeIdx) {
        int[] parent=new int[n], rank=new int[n];
        for(int i=0;i<n;i++)    parent[i]=i;
        int totalWeight=0, edgeUsed=0;
        // Force-include the specified edge first
        if(includeIdx>=0) {
            totalWeight+=edges[includeIdx][2];
            edgeUsed++;
            union(parent, rank, edges[includeIdx][0], edges[includeIdx][1]);
        }
        // Run Kruskal's on remaining edges
        for(int i=0;i<edges.length;i++) {
            if(i==includeIdx || i==excludeIdx)  continue;
            if(edgeUsed==n-1)   break;
            int u=edges[i][0], v=edges[i][1], weight=edges[i][2];
            if(union(parent, rank, u, v)) {
                totalWeight+=weight;
                edgeUsed++;
            }
        }
        return edgeUsed==n-1?totalWeight:Integer.MAX_VALUE;
    }
    private int find(int[] parent, int x) {
        if(parent[x]!=x)    parent[x]=find(parent, parent[x]);
        return parent[x];
    }
    private boolean union(int[] parent, int[] rank, int u, int v) {
        int rootU=find(parent, u), rootV=find(parent, v);
        if(rootU==rootV)    return false;
        if(rank[rootU]<rank[rootV]) parent[rootU]=rootV;
        else if(rank[rootU]>rank[rootV])    parent[rootV]=rootU;
        else {
            parent[rootU]=rootV;
            rank[rootV]++;
        }
        return true;
    }
}
