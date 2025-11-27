// https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/description/
// using heap
// t.c.=O(nlogn), s.c.=O(n)
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int len=nums.length, left=0, right=0, maxLen=0;
        PriorityQueue<int[]> minHeap=new PriorityQueue<>((a,b)->a[0]-b[0]), 
            maxHeap=new PriorityQueue<>((a,b)->b[0]-a[0]);
        while(right<len) {
            minHeap.offer(new int[]{nums[right], right});
            maxHeap.offer(new int[]{nums[right], right});
            while(maxHeap.peek()[0]-minHeap.peek()[0]>limit) {
                left=Math.min(maxHeap.peek()[1], minHeap.peek()[1])+1;
                while(maxHeap.peek()[1]<left)
                    maxHeap.poll();
                while(minHeap.peek()[1]<left)
                    minHeap.poll();
            }
            maxLen=Math.max(maxLen, right+1-left);
            right++;
        }
        return maxLen;
    }
}

// using multiset
// t.c.=O(nlogn), s.c.=O(n)
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int len=nums.length, left=0, right=0, maxLen=0;
        TreeMap<Integer, Integer> window=new TreeMap<>();
        while(right<len) {
            window.put(nums[right], window.getOrDefault(nums[right], 0)+1);
            while(window.lastKey()-window.firstKey()>limit) {
                window.put(nums[left], window.get(nums[left])-1);
                if(window.get(nums[left])==0)
                    window.remove(nums[left]);
                left++;
            }
            maxLen=Math.max(maxLen, right+1-left);
            right++;
        }
        return maxLen;
    }
}

// using deque
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int len=nums.length, left=0, right=0, maxLen=0;
        Deque<Integer> maxDeque=new ArrayDeque<>(), minDeque=new ArrayDeque<>();
        while(right<len) {
            int num=nums[right];
            while(!maxDeque.isEmpty() && maxDeque.peekLast()<num)
                maxDeque.pollLast();
            maxDeque.offerLast(num);
            while(!minDeque.isEmpty() && minDeque.peekLast()>num)
                minDeque.pollLast();
            minDeque.offerLast(num);
            while(maxDeque.peekFirst()-minDeque.peekFirst()>limit) {
                if(maxDeque.peekFirst()==nums[left])
                    maxDeque.pollFirst();
                if(minDeque.peekFirst()==nums[left])
                    minDeque.pollFirst();
                left++;
            }
            maxLen=Math.max(maxLen, right+1-left);
            right++;
        }
        return maxLen;
    }
}
