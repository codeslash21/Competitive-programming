// t.c.=O(n), s.c.=O(1)
class Solution {
    public int[] decompressRLElist(int[] nums) {
        int n=nums.length;
        int len = 0, k=0;
        for(int i=0;i<n;i=i+2)
            len+=nums[i];
        int[] res = new int[len];
        for(int i=1;i<n;i=i+2)
            for(int j=0;j<nums[i-1];j++)
                res[k++]=nums[i];
        return res;
    }
}
