// Using bruteforce method
// t.c.=O(n^2), s.c.=O(1)
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++) {
            boolean left=false, right=false;
            for(int j=0;j<i;j++)
                if(nums[j]<nums[i])
                    left=true;
            for(int j=i+1;j<n;j++)
                if(nums[i]<nums[j])
                    right=true;
            if(left && right)
                return true;
        }
        return false;
    }
}

// Using linear scan
// t.c.=O(n), s.c.=O(1)
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first_num=Integer.MAX_VALUE, second_num=Integer.MAX_VALUE;
        for(int n:nums)
            if(n<=first_num)
                first_num=n;
            else if(n<=second_num)
                second_num=n;
            else
                return true;
        return false;
    }
}
