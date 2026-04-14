// https://leetcode.com/problems/number-of-recent-calls/description/
// using queue
class RecentCounter {
    Deque<Integer> queue;
    int requestCount;
    public RecentCounter() {
        queue=new ArrayDeque<>();
        requestCount=0;
    }
    
    public int ping(int t) {
        queue.add(t);
        while(queue.peekFirst()<(t-3000))
            queue.pollFirst();
        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
