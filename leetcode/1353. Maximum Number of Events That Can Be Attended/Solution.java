// https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/description/
class Solution {
    public int maxEvents(int[][] events) {
        // sort events by startDay
        Arrays.sort(events, (a,b)->Integer.compare(a[0], b[0]));
        int eventAttended=0, totalEvents=events.length, maxDay=0, idx=0;
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        for(int[] event:events)
            maxDay=Math.max(maxDay, event[1]);
        for(int day=1;day<=maxDay;day++) {
            // add all events starting today
            while(idx<totalEvents && events[idx][0]==day)
                minHeap.offer(events[idx++][1]);
            // remove expired events
            while(!minHeap.isEmpty() && minHeap.peek()<day)
                minHeap.poll();
            // attend the event ending earliest
            if(!minHeap.isEmpty()) {
                minHeap.poll();
                eventAttended++;
            }
        }
        return eventAttended;
    }
}
