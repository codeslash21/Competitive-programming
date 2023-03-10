// Using left and right array
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] left=new int[n];
        int[] right=new int[n];
        int[] answer=new int[n];
        int l=1,r=1;
        for(int i=0;i<n;i++) {
            left[i]=l;
            l*=nums[i];
        }
        for(int i=n-1;i>=0;i--) {
            right[i]=r;
            r*=nums[i];
        }
        for(int i=0;i<n;i++)
            answer[i]=left[i]*right[i];
        return answer;
    }
}

// Using the space of output array
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
       int[] answer=new int[n];
        int l=1,r=1;
        for(int i=0;i<n;i++) {
            answer[i]=l;
            l*=nums[i];
        }
        for(int i=n-1;i>=0;i--) {
            answer[i]=answer[i]*r;
            r*=nums[i];
        }
        return answer;
    }
}
