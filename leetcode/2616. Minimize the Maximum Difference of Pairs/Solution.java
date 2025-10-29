// https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/description/
class Solution {
    public int countValidPairs(int[] nums, int maxDiff) {
        int index=0, count=0, len=nums.length;
        while(index<len-1) {
            if(nums[index+1]-nums[index]<=maxDiff) {
                count++;
                index++;
            }
            index++;
        }
        return count;
    }
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int len=nums.length, left=0, right=nums[len-1]-nums[0];
        while(left<right) {
            int mid=left+(right-left)/2;
            if(countValidPairs(nums, mid)>=p)
                right=mid;
            else
                left=mid+1;
        }
        return left;
    }
}
