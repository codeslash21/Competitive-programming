// https://leetcode.com/problems/find-the-power-of-k-size-subarrays-i/editorial/
// sliding window + Deque
// t.c.=O(n), s.c.=O(k)
class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int len=nums.length, right=0, idx=0;
        int[] res=new int[len+1-k];
        Deque<Integer> indexDeque=new ArrayDeque<>();
        while(right<len) {
            if(!indexDeque.isEmpty() && indexDeque.peekFirst()<right+1-k)
                indexDeque.pollFirst();
            if(!indexDeque.isEmpty() && nums[right]!=nums[right-1]+1)
                indexDeque.clear();
            indexDeque.offerLast(right);
            if(right>=k-1)
                res[idx++]=indexDeque.size()==k?nums[right]:-1;
            right++;
        }
        return res;
    }
}

// using counter
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int len=nums.length, right=0, count=0, prev=nums[0]-1;
        int[] res=new int[len+1-k];
        Arrays.fill(res, -1);
        while(right<len) {
            if(nums[right]==prev+1)
                count++;
            else
                count=1;
            if(count>=k)
                res[right+1-k]=nums[right];
            prev=nums[right++];
        }
        return res;
    }
}
