// https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/
// using recursion
// t.c.=O(2^n), s.c.=O(n)
class Solution {
    private int maxLen=0, count=0;
    public int findNumberOfLIS(int[] nums) {
        dfs(nums, Integer.MIN_VALUE, 0, 0);
        return count;
    }
    private void dfs(int[] nums, int prevVal, int currIdx, int currLen) {
        if(currIdx==nums.length) {
            if(currLen>maxLen) {
                maxLen=currLen;
                count=1;
            } else if(currLen==maxLen && maxLen>0)
                count++;
            return;
        }
        dfs(nums, prevVal, currIdx+1, currLen);
        if(nums[currIdx]>prevVal)
            dfs(nums, nums[currIdx], currIdx+1, currLen+1);
    }
}
// using dp
// t.c.=O(n^2), s.c.=O(n)
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length, maxLen=1, result=0;
        int[] length=new int[n], count=new int[n];
        for(int i=0;i<n;i++) {
            length[i]=1;
            count[i]=1;
            for(int j=0;j<i;j++)
                if(nums[j]<nums[i]) {
                    if(length[j]+1>length[i]) {
                        length[i]=length[j]+1;
                        count[i]=count[j];
                    } else if(length[j]+1==length[i]) 
                        count[i]+=count[j];
                }
            maxLen=Math.max(maxLen, length[i]);
        }
        for(int i=0;i<n;i++)
            if(length[i]==maxLen)
                result+=count[i];
        return result;
    }
}
