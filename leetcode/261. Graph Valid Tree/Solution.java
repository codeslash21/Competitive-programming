// https://leetcode.com/problems/graph-valid-tree/description/
// using union find
// t.c.=O(n*alpha(n)), s.c.=O(n)
class Solution {
    private int[] parent, rank;
    public boolean validTree(int n, int[][] edges) {
        int totalEdges=edges.length;
        if(totalEdges>=n || totalEdges<n-1)   return false;
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++)    parent[i]=i;
        for(int[] edge:edges)
            if(!union(edge[0], edge[1]))
                return false;
        return true;
    }
    private int findParent(int x) {
        if(parent[x]!=x)
            parent[x]=findParent(parent[x]);
        return parent[x];
    }
    private boolean union(int x, int y) {
        int rootX=findParent(x), rootY=findParent(y);
        if(rootX==rootY)    return false;
        if(rank[rootX]<rank[rootY])
            parent[rootX]=rootY;
        else if(rank[rootX]>rank[rootY])
            parent[rootY]=rootX;
        else {
            parent[rootX]=rootY;
            rank[rootY]++;
        }
        return true;
    }
}
