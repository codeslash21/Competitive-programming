// https://leetcode.com/problems/subarrays-with-k-different-integers/description/
// sliding window
// t.c.=O(n), s.c.=O(1)
class Solution {
    private int helper(int[] nums, int k) {
        int len=nums.length, left=0, right=0, res=0;
        Map<Integer, Integer> freq=new HashMap<>();
        while(right<len) {
            int num=nums[right];
            freq.put(num, freq.getOrDefault(num, 0)+1);
            while(left<=right && freq.size()==k) {
                res+=len-right;
                int remove=nums[left++];
                freq.put(remove, freq.get(remove)-1);
                if(freq.get(remove)==0)
                    freq.remove(remove);
            }
            right++;
        }
        return res;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums, k)-helper(nums, k+1);
    }
}
