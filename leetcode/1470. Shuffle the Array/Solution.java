// https://leetcode.com/problems/shuffle-the-array/description/
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int[] shuffle(int[] nums, int n) {
        int base=1001, len=nums.length;
        for(int i=0;i<n;i++) {
            nums[2*i]+=(nums[i] % base) * base;
            nums[2*i+1]+=(nums[n+i] % base) * base;
        }
        for(int i=0;i<len;i++)
            nums[i]/=base;
        return nums;
    }
}
