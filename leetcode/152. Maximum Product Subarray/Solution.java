// Using brute force method
// t.c.=O(n^2), s.c.=O(1)
class Solution {
    public int maxProduct(int[] nums) {
        int maxProd=Integer.MIN_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++) {
            int currProd=1;
            for(int j=i;j<n;j++) {
                currProd*=nums[j];
                maxProd=Math.max(maxProd, currProd);
            }
        }
        return maxProd;
    }
}

// Using scanning of array
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        if(n==0)
            return 0;
        int max_so_far=nums[0];
        int min_so_far=nums[0];
        int result=max_so_far;
        for(int i=1;i<n;i++) {
            int curr=nums[i];
            int temp_max=Math.max(curr, Math.max(max_so_far*curr, min_so_far*curr));
            min_so_far=Math.min(curr, Math.min(max_so_far*curr, min_so_far*curr));
            max_so_far=temp_max;
            result=Math.max(result, max_so_far);
        }
        return result;
    }
}
