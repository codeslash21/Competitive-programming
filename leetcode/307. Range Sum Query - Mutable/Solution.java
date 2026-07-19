// https://leetcode.com/problems/range-sum-query-mutable/description/
// using prefix sum
// t.c.=O(n) for update, O(1) for range sum, s.c.=O(n)
class NumArray {
    private int[] nums, prefix;
    int len;
    public NumArray(int[] nums) {
        this.nums=nums;
        this.len=nums.length;
        prefix=new int[len+1];
        for(int i=0;i<len;i++)
            prefix[i+1]=prefix[i]+nums[i];
    }
    
    public void update(int index, int val) {
        int delta=val-nums[index];
        nums[index]=val;
        for(int i=index+1;i<=len;i++)
            prefix[i]+=delta;
    }
    
    public int sumRange(int left, int right) {
        return prefix[right+1]-prefix[left];
    }
}
