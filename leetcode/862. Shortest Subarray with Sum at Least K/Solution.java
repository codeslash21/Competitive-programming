// https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/description/
// using queue
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int len=nums.length, minLen=Integer.MAX_VALUE;
        long[] prefixSum=new long[len+1];
        Deque<Integer> deque=new ArrayDeque<>();
        for(int i=0;i<len;i++)
            prefixSum[i+1]=prefixSum[i]+nums[i];
        for(int j=0;j<=len;j++) {
            while(!deque.isEmpty() && prefixSum[deque.peekLast()]>=prefixSum[j])
                deque.pollLast();
            while(!deque.isEmpty() && prefixSum[j]-prefixSum[deque.peekFirst()]>=k)
                minLen=Math.min(minLen, j-deque.pollFirst());
            deque.offerLast(j);
        }
        return minLen==Integer.MAX_VALUE?-1:minLen;
    }
}
