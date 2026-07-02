// https://leetcode.com/problems/path-with-maximum-probability/description/
// using Dijkstra's algo
// t.c.=O(ElogV), s.c.=O(E+V)
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<double[]>[] graph=new ArrayList[n];
        double[] maxProb=new double[n];
        PriorityQueue<double[]> maxHeap=new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        for(int i=0;i<n;i++)
            graph[i]=new ArrayList<>();
        for(int i=0;i<edges.length;i++) {
            graph[edges[i][0]].add(new double[]{edges[i][1], succProb[i]});
            graph[edges[i][1]].add(new double[]{edges[i][0], succProb[i]});
        }
        Arrays.fill(maxProb, Double.MIN_VALUE);
        // maxHeap contains pair of {prob, node}
        maxHeap.offer(new double[]{1.0, start_node});
        while(!maxHeap.isEmpty()) {
            double[] curr=maxHeap.poll();
            double prob=curr[0];
            int node=(int)curr[1];
            if(node==end_node)  return prob;
            if(maxProb[node]>prob)  continue;
            for(double[] neighbor:graph[node]) {
                double nextProb=prob*neighbor[1];
                int nextNode=(int)neighbor[0];
                if(maxProb[nextNode]<nextProb) {
                    maxProb[nextNode]=nextProb;
                    maxHeap.offer(new double[]{nextProb, nextNode});
                }
            }
        }
        return 0;
    }
}
