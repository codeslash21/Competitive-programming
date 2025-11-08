// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
// two pointers
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int removeDuplicates(int[] nums) {
        int len=nums.length, insert=0, idx=0, groupSize=1;
        while(idx<len) {
            while(idx+groupSize<len && nums[idx]==nums[idx+groupSize])
                groupSize++;
            nums[insert++]=nums[idx];
            if(groupSize>1)
                nums[insert++]=nums[idx];
            idx+=groupSize;
            groupSize=1;
        }
        return insert;
    }
}
