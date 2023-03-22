// Using binary search approach
// t.c.=O(n^2logn), s.c.=O(1)
class Solution {
    public int binSearch(int[] nums, int start, int end, int target) {
        int idx=-1;
        while(start<=end) {
            int mid = (start+end)/2;
            if(nums[mid]<target) {
                idx=mid;
                start=mid+1;
            }
            else
                end=mid-1;
        }
        return idx;
    }
    public int twoSum(int[] nums, int start, int end, int target) {
        int cnt=0;
        for(int i=start;i<end;i++) {
            int idx = binSearch(nums, i+1, end, target-nums[i]);
            if(idx==-1)
                continue;
            cnt+=(idx-i);
        }
        return cnt;
    }
    public int threeSumSmaller(int[] nums, int target) {
        int n=nums.length;
        Arrays.sort(nums);
        int cnt=0;
        for(int i=0;i<n-2;i++) 
            cnt+=twoSum(nums, i+1, n-1, target-nums[i]);
        return cnt;
    }
}

// Using two pointer technique
// t.c.=O(n^2), s.c.=O(1)
class Solution {
     public int twoSum(int[] nums, int start, int end, int target) {
        int cnt=0;
        while(start<end) {
            if(nums[start]+nums[end]<target) {
                cnt+=(end-start);
                start++;
            }
            else
                end--;
        }
        return cnt;
    }
    public int threeSumSmaller(int[] nums, int target) {
        int n=nums.length;
        Arrays.sort(nums);
        int cnt=0;
        for(int i=0;i<n-2;i++) 
            cnt+=twoSum(nums, i+1, n-1, target-nums[i]);
        return cnt;
    }
}
