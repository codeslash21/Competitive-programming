// https://leetcode.com/problems/ipo/description/
// using bruteforce
// t.c.=O(n*k), s.c.=O(n)
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int len=profits.length;
        boolean[] used=new boolean[len];
        for(int j=0;j<k;j++) {
            int bestIdx=-1, bestProfit=-1;
            for(int i=0;i<len;i++) 
                if(!used[i] && capital[i]<=w && profits[i]>bestProfit) {
                    bestProfit=profits[i];
                    bestIdx=i;
                }
            if(bestIdx==-1) break;
            w+=bestProfit;
            used[bestIdx]=true;
        }
        return w;
    }
}

// using heap
// t.c.=O(nlogn), s.c.=O(n)
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int len=profits.length, idx=0;
        int[][] projects=new int[len][2];
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<len;i++) {
            projects[i][0]=capital[i];
            projects[i][1]=profits[i];
        }
        Arrays.sort(projects, (a,b)->a[0]-b[0]);
        for(int i=0;i<k;i++) {
            while(idx<len && projects[idx][0]<=w)
                maxHeap.offer(projects[idx++][1]);
            if(maxHeap.isEmpty())  break;
            w+=maxHeap.poll();
        }
        return w;
    }
}
