// https://leetcode.com/problems/jump-game-vi/description/
// using dp
// t.c.=O(n*k), s.c.=O(n)
class Solution {
    public int maxResult(int[] nums, int k) {
        int len=nums.length, score=0;
        int[] dp=new int[len];
        dp[0]=nums[0];
        for(int i=1;i<len;i++) {
            int maxPrev=Integer.MIN_VALUE;
            for(int j=i-1;j>=Math.max(0, i-k);j--)
                maxPrev=Math.max(maxPrev, dp[j]);
            dp[i]=maxPrev+nums[i];
        }
        return dp[len-1];
    }
}

// using max heap
// t.c.=O(nlogn), s.c.=O(n)
class Solution {
    public int maxResult(int[] nums, int k) {
        int len=nums.length, score=0;
        PriorityQueue<int[]> maxHeap=new PriorityQueue<>((a,b)->b[1]-a[1]);
        int[] dp=new int[len];
        dp[0]=nums[0];
        maxHeap.offer(new int[]{0, dp[0]});
        for(int i=1;i<len;i++) {
            while(maxHeap.peek()[0]<(i-k))
                maxHeap.poll();
            dp[i]=maxHeap.peek()[1]+nums[i];
            maxHeap.offer(new int[]{i, dp[i]});
        }
        return dp[len-1];
    }
}


// using deque
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int maxResult(int[] nums, int k) {
        int len=nums.length, score=0;
        Deque<Integer> queue=new ArrayDeque<>();
        int[] dp=new int[len];
        dp[0]=nums[0];
        queue.add(0);
        for(int i=1;i<len;i++) {
            while(queue.peekFirst()<(i-k))
                queue.pollFirst();
            dp[i]=dp[queue.peekFirst()]+nums[i];
            while(!queue.isEmpty() && dp[queue.peekLast()]<=dp[i])
                queue.pollLast();
            queue.offerLast(i);
        }
        return dp[len-1];
    }
}
