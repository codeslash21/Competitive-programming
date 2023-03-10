// Using brute-force method check the sum for all the subarray
// t.c.=O(n^2), s.c.=O(1)
class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length, maxSubarray=Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            int currSubarray=0;
            for(int j=i;j<n;j++) {
                currSubarray+=nums[j];
                maxSubarray=Math.max(maxSubarray, currSubarray);
            }
        }
        return maxSubarray;
    }
}

// Using devide and conqure technique
// t.c.=O(nlogn), s.c.=O(logn)
class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        return findBestSubarray(nums, 0, n-1);
    }
    public int findBestSubarray(int[] nums, int left, int right) {
        if(left>right)
            return Integer.MIN_VALUE;
        int mid=(left+right)/2;
        int curr=0, leftHalf=0, rightHalf=0;
        for(int i=mid-1;i>=left;i--) {
            curr+=nums[i];
            leftHalf=Math.max(leftHalf, curr);
        }
        curr=0;
        for(int i=mid+1;i<=right;i++) {
            curr+=nums[i];
            rightHalf=Math.max(rightHalf, curr);
        }
        int bestCombinedSum=leftHalf + nums[mid] + rightHalf;
        int leftBestSum=findBestSubarray(nums, left, mid-1);
        int rightBestSum=findBestSubarray(nums, mid+1, right);

        return Math.max(bestCombinedSum, Math.max(leftBestSum, rightBestSum));
    }
}

// Using Kadane's algorithm
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int currSubarray=nums[0], maxSubarray=nums[0];
        for(int i=1;i<n;i++) {
            int num=nums[i];
            currSubarray=Math.max(currSubarray+num, num);
            maxSubarray=Math.max(maxSubarray, currSubarray);
        }
        return maxSubarray;
    }
}
