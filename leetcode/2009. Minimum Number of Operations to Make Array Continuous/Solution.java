// https://leetcode.com/problems/minimum-number-of-operations-to-make-array-continuous/description/
// binary search
// t.c.=O(nlogn), s.c.=O(n)
class Solution {
    private int findIndexOfRight(int[] nums, int target) {
        int len=nums.length, left=0, right=len-1;
        while(left<=right) {
            int mid=left+(right-left)/2;
            if(nums[mid]<=target)
                left=mid+1;
            else
                right=mid-1;
        }
        return left;
    }
    public int minOperations(int[] nums) {
        Set<Integer> unique=new HashSet<>();
        for(int num:nums)
            unique.add(num);
        int len=nums.length, newLen=unique.size(), idx=0, ans=Integer.MAX_VALUE;
        int[] uniqueNums=new int[newLen];
        for(int num:unique)
            uniqueNums[idx++]=num;
        Arrays.sort(uniqueNums);
        for(int i=0;i<newLen;i++) {
            int left=uniqueNums[i], right=left+len-1;
            int rightIdx=findIndexOfRight(uniqueNums, right);
            int count=rightIdx-i;
            ans=Math.min(ans, len-count);
        }
        return ans;
    }
}

// sliding window
// t.c.=O(nlogn), s.c.=O(n)
class Solution {
    public int minOperations(int[] nums) {
        Set<Integer> unique=new HashSet<>();
        for(int num:nums)
            unique.add(num);
        int len=nums.length, newLen=unique.size(), idx=0, j=0, ans=Integer.MAX_VALUE;
        int[] uniqueNums=new int[newLen];
        for(int num:unique)
            uniqueNums[idx++]=num;
        Arrays.sort(uniqueNums);
        for(int i=0;i<newLen;i++) {
            int left=uniqueNums[i], right=left+len-1;
            while(j<newLen && uniqueNums[j]<=right)
                j++;
            int count=j-i;
            ans=Math.min(ans, len-count);
        }
        return ans;
    }
}
