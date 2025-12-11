// https://leetcode.com/problems/132-pattern/description/
// searching intervals
// t.c.=O(n^2), s.c.=O(n)
class Solution {
    public boolean find132pattern(int[] nums) {
        List<int[]> ranges=new ArrayList<>();
        int len=nums.length, i=0,j=1;
        for(j=1;j<len;j++) {
            if(nums[j-1]>nums[j]) {
                if(i<j-1)
                    ranges.add(new int[]{nums[i], nums[j-1]});
                i=j;
            }
            for(int[] range:ranges)
                if(range[0]<nums[j] && nums[j]<range[1])
                    return true;
        }
        return false;
    }
}
