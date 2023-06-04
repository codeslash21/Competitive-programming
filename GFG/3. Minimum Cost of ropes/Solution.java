

class Solution
{
    long minCost(long arr[], int n) 
    {
        long res = 0;
        PriorityQueue<Long> queue = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++)
            queue.offer(arr[i]);
        while(queue.size()!=1) {
            long cost=0;
            cost+=queue.poll();
            cost+=queue.poll();
            res+=cost;
            queue.offer(cost);
        }
        return res;
    }
}
