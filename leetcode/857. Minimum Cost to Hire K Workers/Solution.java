// https://leetcode.com/problems/minimum-cost-to-hire-k-workers/description/
// using sorting + greedy + maxHeap
// t.c.=O(nlogn), s.c.=O(n)
class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int len=quality.length, qualitySum=0;
        double minCost=Double.MAX_VALUE;
        Integer[] workers=new Integer[len];
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<len;i++)  workers[i]=i;
        Arrays.sort(workers, (a,b)->Double.compare((double)wage[a]/quality[a], (double)wage[b]/quality[b]));
        for(int idx:workers) {
            maxHeap.offer(quality[idx]);
            qualitySum+=quality[idx];
            if(maxHeap.size()>k)
                qualitySum-=maxHeap.poll();
            if(maxHeap.size()==k) {
                double rate=(double)wage[idx]/quality[idx];
                minCost=Math.min(minCost, rate*qualitySum);
            }
        }
        return minCost;
    }
}
