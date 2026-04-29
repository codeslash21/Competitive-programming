// https://leetcode.com/problems/single-threaded-cpu/description/
class Solution {
    public int[] getOrder(int[][] tasks) {
        int totalTasks=tasks.length, minEnqueueTime=Integer.MAX_VALUE, idx=0, processed=0;
        int[] res=new int[totalTasks];
        PriorityQueue<int[]> tasksToProcess=new PriorityQueue<>((a,b)->a[0]-b[0]), 
        availableTasks=new PriorityQueue<>((a,b)-> {
            if(a[0]==b[0])  return a[1]-b[1];
            return a[0]-b[0];
        });
        for(int i=0;i<tasks.length;i++)
            tasksToProcess.offer(new int[]{tasks[i][0], tasks[i][1], i});
        for(int time=tasksToProcess.peek()[0];;time++) {
            if(processed==totalTasks)   break;
            while(!tasksToProcess.isEmpty() && tasksToProcess.peek()[0]<=time) {
                int[] task=tasksToProcess.poll();
                availableTasks.offer(new int[] {task[1], task[2]});
            }
            if(availableTasks.size()>0) {
                int[] processedTask=availableTasks.poll();
                res[idx++]=processedTask[1];
                time+=(processedTask[0]-1);
                processed++;
            } else 
                time=tasksToProcess.peek()[0]-1;
        }
        return res;
    }
}
