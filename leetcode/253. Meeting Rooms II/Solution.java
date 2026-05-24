// https://leetcode.com/problems/meeting-rooms-ii/description/
// t.c.=O(nlogn), s.c.=O(n)
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        int len=intervals.length;
        minHeap.offer(intervals[0][1]);
        for(int i=1;i<len;i++) {
            if(intervals[i][0]>=minHeap.peek())
                minHeap.poll();
            minHeap.offer(intervals[i][1]);
        }
        return minHeap.size();
    }
}
