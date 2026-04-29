// https://leetcode.com/problems/process-tasks-using-servers/description/
// t.c.=O(mlogn), s.c.=O(n)
class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int totalServers = servers.length, totalTasks = tasks.length;
        long time=0;
        int[] res = new int[totalTasks];
        PriorityQueue<int[]> freeServers = new PriorityQueue<>(
                (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        PriorityQueue<long[]> occupiedServers = new PriorityQueue<>((a, b) -> a[0] != b[0] ? Long.compare(a[0], b[0])
                : a[1] != b[1] ? Long.compare(a[1], b[1]) : Long.compare(a[2], b[2]));
        for (int i = 0; i < totalServers; i++)
            freeServers.offer(new int[] { servers[i], i });
        for (int i = 0; i < totalTasks; i++) {
            time=Math.max(time, i);
            if (freeServers.isEmpty())
                time = occupiedServers.peek()[0];
            while (!occupiedServers.isEmpty() && occupiedServers.peek()[0] <= time) {
                long[] freeedServer = occupiedServers.poll();
                freeServers.offer(new int[] { (int) freeedServer[1], (int) freeedServer[2] });
            }
            int[] assignedServer = freeServers.poll();
            res[i] = assignedServer[1];
            occupiedServers.offer(new long[] { time + tasks[i], assignedServer[0], assignedServer[1] });
        }
        return res;
    }
}
