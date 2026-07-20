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

// using BIT
// t.c.=O(n) for building bit, O(logn) for update, O(logn) for query
class FenwickTree {
    private int len;
    private int[] bit;
    // Build BIT from array in O(n)
    public FenwickTree(int[] nums) {
        this.len=nums.length;
        this.bit=new int[len+1];
        // Copy values to 1-indexed BIT array
        for(int i=0;i<len;i++)
            bit[i+1]=nums[i];
        for(int i=1;i<=len;i++) {
            int parent= i + (i & (-i));
            if(parent<=len)
                bit[parent]+=bit[i];
        }
    }
    // Add delta to position index and its parent(1-indexed)
    public void update(int index, int delta) {
        while(index<=len) {
            bit[index]+=delta;
            index=index + (index & (-index));   // go to index's parent
        }
    }
    // Prefix sum from 1 to position index (1-indexed)
    public int query(int index) {
        int sum=0;
        while(index>0) {
            sum+=bit[index];
            index=index - (index & (-index));   // go to index's child
        }
        return sum;
    }
}
class NumArray {
    private FenwickTree bit;
    private int[] nums;
    public NumArray(int[] nums) {
        this.nums=nums;
        this.bit=new FenwickTree(nums);
    }
    
    public void update(int index, int val) {
        bit.update(index+1, val-nums[index]);
        nums[index]=val;
    }
    
    public int sumRange(int left, int right) {
        return bit.query(right+1) - bit.query(left);
    }
}
