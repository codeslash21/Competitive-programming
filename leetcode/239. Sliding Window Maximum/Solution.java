// Using priorityQueue
// t.c.=O(nlogk), s.c.=O(k)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length, j=0;
        int[] res = new int[n-k+1];
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++) {
            heap.add(nums[i]);
            if(heap.size()>k)
                heap.remove(nums[i-k]);
            if(heap.size()==k)
                res[j++]=heap.peek();
        }
        return res;
    }
}
