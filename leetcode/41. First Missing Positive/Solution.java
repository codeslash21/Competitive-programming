// By changing the sign of the number
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        boolean flag=false;
        for(int i=0;i<n;i++)
            if(nums[i]<1 || nums[i]>n)
                nums[i]=1;
            else if(nums[i]==1)
                flag=true;
        if(!flag)
            return 1;
        for(int i=0;i<n;i++){
            int index=Math.abs(nums[i])-1;
            if(nums[index]>0)
                nums[index]*=-1;
        }
        for(int i=0;i<n;i++)
            if(nums[i]>0)
                return i+1;
        return n+1;
    }
}
