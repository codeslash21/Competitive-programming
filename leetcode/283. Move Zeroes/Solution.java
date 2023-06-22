// using queue
// t.c.=O(n), s.c.=O(n)
class Solution {
    public void moveZeroes(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        int n=nums.length;
        for(int num:nums)
            if(num!=0)
                queue.add(num);
        int idx=0;
        while(!queue.isEmpty())
            nums[idx++]=queue.remove();
        while(idx<n)
            nums[idx++]=0;
    }
}

// Using constant space
// t.c.=O(n), s.c.=O(1)
class Solution {
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void moveZeroes(int[] nums) {
        int n=nums.length, z=0;
        for(int curr=0;curr<n;curr++)
            if(nums[curr]!=0)
                swap(nums, z++, curr);
    }
}
