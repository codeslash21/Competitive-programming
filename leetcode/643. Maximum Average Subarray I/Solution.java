// t.c.=O(n), s.c.=O(1)
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n=nums.length;
        double sum=0, max;
        for(int i=0;i<k;i++)
            sum+=nums[i];
        max=sum;
        for(int i=k;i<n;i++) {
            sum+=nums[i]-nums[i-k];
            max=Math.max(max, sum);
        }
        return max/k;
    }
}
