// Using two pointers
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int removeElement(int[] nums, int val) {
        int start=0, end=nums.length-1;
        while(start<=end) {
            if(nums[start]!=val)
                start++;
            else {
                nums[start]=nums[end--];
            }
        }
        return start;
    }
}
