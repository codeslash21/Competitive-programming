// using array
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int partitionDisjoint(int[] nums) {
        int n=nums.length;
        int[] minArr = new int[n];
        minArr[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--) 
            minArr[i]=Math.min(minArr[i+1], nums[i]);
        int max=nums[0];
        for(int i=1;i<n;i++) {
            if(max<=minArr[i])
                return i;
            max=Math.max(max, nums[i]);
        }
        return 0;
    }
}
