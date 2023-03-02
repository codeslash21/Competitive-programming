// Using bruteforce method
// t.c.=O(n), s.c.=O(1)
class Solution {
    public boolean isIdealPermutation(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n-2;i++)
            for(int j=i+2;j<n;j++)
                if(nums[i]>nums[j])
                    return false;
        return true;
    }
}

// remembering minimum element
// t.c.=O(n), s.c.=O(1)
class Solution {
    public boolean isIdealPermutation(int[] nums) {
        int n=nums.length;
        int floor=n;
        for(int i=n-1;i>=2;i--) {
            floor=Math.min(floor, nums[i]);
            if(nums[i-2]>floor)
                return false;
        }
        return true;
    }
}

// Using linear scan
// t.c.=O(n), s.c.=O(1)
class Solution {
    public boolean isIdealPermutation(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++)
            if(Math.abs(nums[i]-i)>1)
                return false;
        return true;
    }
}
