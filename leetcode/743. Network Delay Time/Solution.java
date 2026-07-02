// https://leetcode.com/problems/network-delay-time/description/
// using Bellman-Ford algo
// t.c.=O(E*V), s.c.=O(V)
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int maxTime=0, INF=Integer.MAX_VALUE;
        int[] minTime=new int[n+1];
        Arrays.fill(minTime, INF);
        minTime[k]=0;
        for(int round=0;round<n-1;round++) {
            for(int[] edge:times) {
                int u=edge[0], v=edge[1], w=edge[2];
                if(minTime[u]!=INF && minTime[u]+w<minTime[v])
                    minTime[v]=minTime[u]+w;
            }
        }
        for(int i=1;i<=n;i++) {
            if(minTime[i]==INF) return -1;
            maxTime=Math.max(maxTime, minTime[i]);
        }
        return maxTime;
    }
}

// using Dijkstra' algo
// t.c.=O(ElogV), s.c.=O(E+V)
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph=new List[n+1];
        int[] dist=new int[n+1];
        PriorityQueue<int[]> minHeap=new PriorityQueue<>((a,b)->a[0]-b[0]);
        int maxDist=0, INF=Integer.MAX_VALUE;
        for(int i=1;i<=n;i++)
            graph[i]=new ArrayList<>();
        for(int[] edge:times)
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
        for(int i=1;i<=n;i++)
            dist[i]=INF;
        dist[k]=0;
        minHeap.offer(new int[]{0,k});
        while(!minHeap.isEmpty()) {
            int[] curr=minHeap.poll();
            int d=curr[0], u=curr[1];
            if(d>dist[u])   continue;
            for(int[] neighbor:graph[u]) {
                int v=neighbor[0], w=neighbor[1];
                if(dist[v]>dist[u]+w) {
                    dist[v]=dist[u]+w;
                    minHeap.offer(new int[]{dist[v], v});
                }
            }
        }
        for(int d:dist) {
            if(d==INF)  return -1;
            if(d>maxDist)   maxDist=d;
        }
        return maxDist;
    }
}
