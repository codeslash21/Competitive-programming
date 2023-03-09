// Using binary search
// t.c.=O(n) worst case, O(logn) best case, s.c.=O(1)
class Solution {
    public boolean search(int[] nums, int target) {
        int n=nums.length;
        int start=0, end=n-1;
        while(start<=end) {
            int mid=(start+end)/2;
            if(nums[mid]==target)
                return true;
            if(nums[start]==nums[mid]) {
                start++;
                continue;
            }
            if(nums[mid]>nums[start])
                if(target>=nums[start] && target<nums[mid])
                    end=mid-1;
                else    
                    start=mid+1;
            else if(nums[mid]<nums[start])
                if(target>nums[mid] && target<=nums[end])
                    start=mid+1;
                else
                    end=mid-1;
            
        }
        return false;
    }
}
