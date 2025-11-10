// https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/description/
// using binary search
// t.c.=O(nlogn), s.c.=O(n)
class Solution {
    public int findIndexOfMax(int[] nums, int target) {
        int left=0, right=nums.length-1;
        while(left<=right) {
            int mid=left+(right-left)/2;
            if(nums[mid]<=target)
                left=mid+1;
            else
                right=mid-1;
        }
        return right;
    }
    public int numSubseq(int[] nums, int target) {
        int len=nums.length, mod=(int)1e9+7, ans=0, left=0, right=len-1;
        Arrays.sort(nums);
        int[] power=new int[len];
        power[0]=1;
        for(int i=1;i<len;i++)
            power[i]=(power[i-1]*2)%mod;
        while(left<=right) {
            right=findIndexOfMax(nums, target-nums[left]);
            if(right<left)
                break;
            ans+=power[right-left++];
            ans%=mod;
        }
        return ans;
    }
}

// Using two pointers
// t.c.=O(nlogn), s.c.=O(logn)
class Solution {
    public int numSubseq(int[] nums, int target) {
        int len=nums.length, mod=(int)1e9+7, ans=0, left=0, right=len-1;
        Arrays.sort(nums);
        int[] power=new int[len];
        power[0]=1;
        for(int i=1;i<len;i++)
            power[i]=(power[i-1]*2)%mod;
        while(left<=right) {
            if(nums[left]+nums[right]<=target) {
                ans+=power[right-left++];
                ans%=mod;
            } else
                right--;
        }
        return ans;
    }
}

