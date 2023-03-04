// Using prefix Sum technique
// t.c.=O(n^2), s.c.=O(n)
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n=nums.length, result=0;
        int[] prefixSum = new int[n+1];
        prefixSum[0]=0; prefixSum[1]=nums[0];
        for(int i=1;i<n;i++)
            prefixSum[i+1]=prefixSum[i]+nums[i];
        for(int i=n;i>0;i--)
            for(int j=i-1;j>=0;j--)
                if((prefixSum[i]-prefixSum[j])%k==0)
                    result+=1;
        return result;
    }
}

// Using counting
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n=nums.length, result=0, prefixMod=0;
        int[] mod=new int[k];
        mod[0]=1;
        for(int num:nums) {
            prefixMod = (prefixMod + num%k + k)%k;
            result+=mod[prefixMod];
            mod[prefixMod]++;
        }
        return result;
    }
}
