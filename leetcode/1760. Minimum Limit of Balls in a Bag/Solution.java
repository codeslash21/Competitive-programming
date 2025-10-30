// https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/
// t.c.=O(NlogV), s.c.=O(1), V=max(nums)
class Solution {
    public boolean dividePossible(int[] nums, int maxSize, int maxOperations) {
        int operations=0;
        for(int num:nums)
            operations+=Math.ceil((double)num/maxSize)-1;
        return !(operations>maxOperations);
    }
    public int minimumSize(int[] nums, int maxOperations) {
        int len=nums.length, left=1, right=Arrays.stream(nums).max().getAsInt();
        while(left<right) {
            int mid=left+(right-left)/2;
            if(dividePossible(nums, mid, maxOperations))
                right=mid;
            else
                left=mid+1;
        }
        return left;
    }
}
