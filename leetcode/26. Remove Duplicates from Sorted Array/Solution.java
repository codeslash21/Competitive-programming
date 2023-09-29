// Using two pointers
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length, insertIdx=1;
        for(int i=1;i<n;i++)
            if(nums[i]!=nums[i-1]) {
                nums[insertIdx]=nums[i];
                insertIdx++;
            }
        return insertIdx;
    }
}
