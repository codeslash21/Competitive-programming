// Using Sorting and PriorityQueue
// t.c. = O(nlogn), s.c. = O(n)
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<List<Integer>> jobs = new ArrayList<>();
        int length = startTime.length;
        for(int i=0;i<length;i++) {
            List<Integer> currJob = new ArrayList<>();
            currJob.add(startTime[i]);
            currJob.add(endTime[i]);
            currJob.add(profit[i]);
            jobs.add(currJob);
        }
        Collections.sort(jobs, (a,b) -> a.get(0)-b.get(0));
        return findMaxProfit(jobs);
    }
    public int findMaxProfit(List<List<Integer>> jobs) {
        int len = jobs.size(), maxProfit = 0;
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> a, List<Integer> b) {
                return a.get(0)-b.get(0);
            }
        });
        for(int i=0;i<len;i++) {
            List<Integer> currJob = jobs.get(i);
            int startTime = currJob.get(0), endTime = currJob.get(1), profit = currJob.get(2);
            while(!minHeap.isEmpty() && startTime>=minHeap.peek().get(0))
                maxProfit = Math.max(maxProfit, minHeap.poll().get(1));
            List<Integer> jobChain = new ArrayList<>();
            jobChain.add(endTime);
            jobChain.add(maxProfit+profit);
            minHeap.add(jobChain);
        }
        while(!minHeap.isEmpty())
            maxProfit = Math.max(maxProfit, minHeap.poll().get(1));
        return maxProfit;
    }
}


// Using DP and binary search
// t.c.=O(nlogn), s.c.=O(n)
class Solution {
    int[] memo;
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<List<Integer>> jobs = new ArrayList<>();
        int length = startTime.length;
        int[] startTimes = new int[length];
        memo = new int[length];
        Arrays.fill(memo, -1);
        for(int i=0;i<length;i++) {
            List<Integer> currJob = new ArrayList<>();
            currJob.add(startTime[i]);
            currJob.add(endTime[i]);
            currJob.add(profit[i]);
            jobs.add(currJob);
        }
        Collections.sort(jobs, (a,b) -> a.get(0)-b.get(0));
        for(int i=0;i<length;i++)
            startTimes[i] = jobs.get(i).get(0);
        return findMaxProfit(jobs, startTimes, length, 0);
    }
    public int findMaxProfit(List<List<Integer>> jobs, int[] startTimes, int length, int position) {
        if(position==length)
            return 0;
        if(memo[position]!=-1)
            return memo[position];
        int nextIndex = findNextJob(startTimes, jobs.get(position).get(1), position);
        int maxProfit = Math.max(findMaxProfit(jobs, startTimes, length, position+1), jobs.get(position).get(2)+findMaxProfit(jobs, startTimes, length, nextIndex));
        memo[position]=maxProfit;
        return memo[position];
    }
    public int findNextJob(int[] startTimes, int lastEndTime, int lastIndex) {
        int left=lastIndex, right=startTimes.length-1, nextIndex=startTimes.length;
        while(left<=right) {
            int mid=left+(right-left)/2;
            if(startTimes[mid]>=lastEndTime) {
                nextIndex=mid;
                right=mid-1;
            } else
                left=mid+1;
        }
        return nextIndex;
    }
}
