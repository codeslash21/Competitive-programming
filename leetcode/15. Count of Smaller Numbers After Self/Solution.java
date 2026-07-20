// https://leetcode.com/problems/count-of-smaller-numbers-after-self/description/
// using Fenwick tre
// t.c.=O(nlogm), s.c.=O(m)
class FenwickTree {
    private int len;
    private int[] bit;
    public FenwickTree(int size) {
        this.len=size;
        bit=new int[len];
    }
    public void update(int index, int delta) {
        while(index<=len) {
            bit[index]+=delta;
            index=index + (index & (-index));
        }
    }
    public int query(int index) {
        int total=0;
        while(index>0) {
            total+=bit[index];
            index=index- (index & (-index));
        }
        return total;
    }
}
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int offset=10001, size=20003, n=nums.length;
        FenwickTree bit=new FenwickTree(size);
        List<Integer> result=new LinkedList<>();
        for(int i=n-1;i>=0;i--) {
            int shiftedVal=nums[i]+offset;
            result.addFirst(bit.query(shiftedVal-1));
            bit.update(shiftedVal, 1);
        }
        return result;
    }
}
