// One pass approach
// t.c.=O(n), s.c.=O(1)
class Solution {
    public void swap(int[] nums, int a, int b) {
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
    public void reverse(int[] nums, int start, int end) {
        while(start<end) 
            swap(nums, start++, end--);
    }
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        boolean flag=false;
        int i=n-2;
        while(i>=0 && nums[i]>=nums[i+1])
            i--;
        if(i>=0) {
            for(int j=n-1;j>i;j--)
                if(nums[j]>nums[i]) {
                    swap(nums, i, j);
                    break;
                }
        }
        reverse(nums, i+1, n-1);
    }
}
