// https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/description/
// using Dijkstra's algo
// t.c.=O(ElogV), s.c.=O(V+E), E=len(roads), v=n
class Solution {
    public int countPaths(int n, int[][] roads) {
        int mod=1_000_000_007;
        // build the graph (adjacency list)
        List<long[]>[] graph=new List[n];
        for(int i=0;i<n;i++)    graph[i]=new ArrayList<>();
        for(int[] road:roads) {
            graph[road[0]].add(new long[]{road[1], road[2]});
            graph[road[1]].add(new long[]{road[0], road[2]});
        }
        // initialize dist[] and ways[] array
        long[] dist=new long[n], ways=new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0]=0;
        ways[0]=1;
        // define the minHeap, it contains {dist, node}
        PriorityQueue<long[]> minHeap=new PriorityQueue<>((a,b)->Long.compare(a[0], b[0]));
        minHeap.offer(new long[]{0, 0});
        while(!minHeap.isEmpty()) {
            long[] curr=minHeap.poll();
            long distU=curr[0];
            int u=(int)curr[1];
            // skip stale entry
            if(distU>dist[u])   continue;
            for(long[] edge:graph[u]) {
                int v=(int) edge[0];
                long w=edge[1], newDist=distU+w;
                if(newDist<dist[v]) {
                    dist[v]=newDist;
                    ways[v]=ways[u];
                    minHeap.offer(new long[]{newDist, v});
                } else if(newDist==dist[v])
                    ways[v]=(ways[v]+ways[u])%mod;
            }
        }
        return (int)ways[n-1];
    }
}
