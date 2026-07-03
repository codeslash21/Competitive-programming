// https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
// using Dijkstra's algo
// 
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int INF=Integer.MAX_VALUE;
        List<int[]>[] graph=new List[n];
        int[][] minCost=new int[n][k+1];
        PriorityQueue<int[]> minHeap=new PriorityQueue<>((a,b)->a[0]-b[0]);
        // build the graph
        for(int i=0;i<n;i++)
            graph[i]=new ArrayList<>();
        for(int[] flight:flights)
            graph[flight[0]].add(new int[]{flight[1], flight[2]});
        // initialize minCost array with max integer value
        for(int[] row:minCost)
            Arrays.fill(row, INF);
        // minHeap contains pair of {cost, city, stop}
        minHeap.offer(new int[]{0, src, -1});
        while(!minHeap.isEmpty()) {
            int[] curr=minHeap.poll();
            int cost=curr[0], city=curr[1], stop=curr[2];
            if(city==dst)   return cost;
            if(stop==k || (stop>=0 && cost>minCost[city][stop])) continue;
            for(int[] neighbor:graph[city]) {
                int nextCity=neighbor[0], price=neighbor[1];
                int nextCost=cost+price, nextStop=stop+1;
                if(minCost[nextCity][nextStop]>nextCost) {
                    minCost[nextCity][nextStop]=nextCost;
                    minHeap.offer(new int[]{nextCost, nextCity, nextStop});
                }
            }
        }
        return -1;
    }
}

// using bellman-ford's algo
// t.c.=O(k(n+E)), s.c.=O(n)
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int INF=Integer.MAX_VALUE;
        int[] dist=new int[n];
        Arrays.fill(dist, INF);
        dist[src]=0;
        for(int i=0;i<=k;i++) {
            int[] prevDist=dist.clone();
            for(int[] flight:flights) {
                int from=flight[0], to=flight[1], price=flight[2];
                if(prevDist[from]!=INF && prevDist[from]+price<dist[to])
                    dist[to]=prevDist[from]+price;
            }
        }
        return dist[dst]==INF?-1:dist[dst];
    }
}
