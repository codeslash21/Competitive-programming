// https://leetcode.com/problems/path-with-minimum-effort/description/
// using dijkstra's algo
// t.c.=O(mn*logmn), s.c.=O(mn)
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows=heights.length, cols=heights[0].length, INF=Integer.MAX_VALUE;
        int[][] dirs=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int[][] dist=new int[rows][cols];
        PriorityQueue<int[]> minHeap=new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int[] row:dist) Arrays.fill(row, INF);
        dist[0][0]=0;
        // heap contains pair of {dist, row, col};
        minHeap.offer(new int[]{0, 0, 0});
        while(!minHeap.isEmpty()) {
            int[] pair=minHeap.poll();
            int diff=pair[0], row=pair[1], col=pair[2];
            if(row==rows-1 && col==cols-1)  return diff;
            if(diff>dist[row][col]) continue;
            for(int[] dir:dirs) {
                int newRow=row+dir[0], newCol=col+dir[1];
                if(newRow<0 || newRow>=rows || newCol<0 || newCol>=cols)    continue;
                int newDiff=Math.max(diff, Math.abs(heights[row][col]-heights[newRow][newCol]));
                if(newDiff<dist[newRow][newCol]) {
                    dist[newRow][newCol]=newDiff;
                    minHeap.offer(new int[]{newDiff, newRow, newCol});
                }
            }
        }
        return 0;
    }
}

// using Kruskal's algo
// t.c.=O(mnlogmn), s.c.=O(mn)
class DSU {
    private int[] parent, rank;
    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
    }
    public int find(int node) {
        if (parent[node] != node)
            parent[node] = find(parent[node]);
        return parent[node];
    }
    public boolean union(int u, int v) {
        int pu = find(u), pv = find(v);
        if (pu == pv)   return false;
        if(rank[pu]<rank[pv])
            parent[pu]=pv;
        else if(rank[pu]>rank[pv])
            parent[pv]=pu;
        else {
            parent[pu]=pv;
            rank[pv]++;
        }
        return true;
    }
}

public class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        List<int[]> edges = new ArrayList<>();
        // each edge store (weight, cell1, cell2)
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (r + 1 < rows)
                    edges.add(new int[]{Math.abs(heights[r][c] - heights[r + 1][c]), r * cols + c, (r + 1) * cols + c});
                if (c + 1 < cols)
                    edges.add(new int[]{Math.abs(heights[r][c] - heights[r][c + 1]), r * cols + c, r * cols + c + 1});
            }
        }
        edges.sort(Comparator.comparingInt(a -> a[0]));
        DSU dsu = new DSU(rows * cols);
        for (int[] edge : edges) {
            int weight = edge[0], u = edge[1], v = edge[2];
            dsu.union(u, v);
            if (dsu.find(0) == dsu.find(rows * cols - 1))   return weight;
        }
        return 0;
    }
}


