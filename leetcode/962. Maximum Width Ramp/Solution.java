// https://leetcode.com/problems/maximum-width-ramp/description/
// using sorting
// t.c.=O(nlogn), s.c.=O(n)
class Solution {
    public int maxWidthRamp(int[] nums) {
        int len=nums.length, minIdx=len, maxWidth=0;
        Integer[] indices=new Integer[len];
        for(int i=0;i<len;i++)
            indices[i]=i;
        Arrays.sort(indices, (a,b)->nums[a]==nums[b]?a-b:nums[a]-nums[b]);
        for(int idx:indices) {
            maxWidth=Math.max(maxWidth, idx-minIdx);
            minIdx=Math.min(minIdx, idx);
        }
        return maxWidth;
    }
}
