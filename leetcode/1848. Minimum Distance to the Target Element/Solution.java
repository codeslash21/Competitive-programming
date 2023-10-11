// using two pointers
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int n=nums.length, left=start-1, right=start, res=100000;
        while(left>-1) {
            if(nums[left]==target) {
                res=Math.min(start-left, res);
                break;
            }
            left--;
        }
        while(right<n) {
            if(nums[right]==target) {
                res=Math.min(right-start, res);
                break;
            }
            right++;
        }
        return res;
    }
}
