// https://leetcode.com/problems/swim-in-rising-water/
// using Dijkstra's algo
// t.c.=O(n^2*logn), s.c.=O(n^2)
class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int[][] dirs=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int[][] dist=new int[n][n];
        PriorityQueue<int[]> minHeap=new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int[] row:dist) Arrays.fill(row, Integer.MAX_VALUE);
        minHeap.offer(new int[]{grid[0][0], 0, 0});
        dist[0][0]=grid[0][0];
        while(!minHeap.isEmpty()) {
            int[] curr=minHeap.poll();
            int t=curr[0], r=curr[1], c=curr[2];
            if(r==n-1 && c==n-1)    return t;
            if(dist[r][c]<t)    continue;
            for(int[] dir:dirs) {
                int newR=r+dir[0], newC=c+dir[1];
                if(newR<0 || newR>=n || newC<0 || newC>=n)  continue;
                int newT=Math.max(t, grid[newR][newC]);
                if(newT<dist[newR][newC]) {
                    dist[newR][newC]=newT;
                    minHeap.offer(new int[]{newT, newR, newC});
                }
            }
        }
        return n*n;
    }
}
