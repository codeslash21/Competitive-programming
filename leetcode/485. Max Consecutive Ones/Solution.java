class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int len=nums.length, left=0, right=0, sum=0, res=0;
        while(right<len) {
            sum+=nums[right];
            if(sum!=(right-left+1)) {
                left=right+1;
                sum=0;
            }
            res=Math.max(res, right-left+1);
            right++;
        }
        return res;
    }
}
