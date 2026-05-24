// https://leetcode.com/problems/meeting-rooms-iii/description/
// t.c.=O(nlogn), s.c.=O(n)
class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a,b)->a[0]-b[0]);
        int[] count=new int[n];
        int result=0;
        PriorityQueue<Integer> availableRooms=new PriorityQueue<>();
        PriorityQueue<long[]> busyRooms=new PriorityQueue<>((a,b)->a[1]==b[1]?Long.compare(a[0], b[0]):Long.compare(a[1], b[1]));
        for(int i=0;i<n;i++)    availableRooms.offer(i);
        for(int[] meeting:meetings) {
            long start=meeting[0], end=meeting[1];
            // free up rooms that have finished by this meeting's start
            while(!busyRooms.isEmpty() && busyRooms.peek()[1]<=start)
                availableRooms.offer((int)busyRooms.poll()[0]);
            // assign room with lowest number from all the available rooms
            if(!availableRooms.isEmpty()) {
                int room=availableRooms.poll();
                busyRooms.offer(new long[]{room, end});
                count[room]++;
            } else {
                // if no room available delay until earliest room frees
                long[] earliest=busyRooms.poll();
                long newEnd=earliest[1]+(end-start);
                int room=(int)earliest[0];
                busyRooms.offer(new long[]{room, newEnd});
                count[room]++;
            }
        }
        for(int i=1;i<n;i++)
            if(count[i]>count[result])  result=i;
        return result;
    }
}
