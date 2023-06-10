// using bit manipulation
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int totalHammingDistance(int[] nums) {
        int n=nums.length, ans=0;
        int[] arr = new int[32];
        for(int i=0;i<n;i++) {
            int a = nums[i];
            int bit=0;
            while(a!=0) {
                if(a%2==1)
                    arr[bit]+=1;
                a>>=1;
                bit++;
            }
        }
        for(int i=0;i<32;i++) 
            ans=ans+(n-arr[i])*arr[i];
        return ans;
    }
}
