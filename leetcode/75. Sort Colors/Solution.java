// Using counting sort
// t.c.=O(n), s.c.=O(1)
class Solution {
    public void sortColors(int[] nums) {
        int c0=0,c1=0,c2=0, i=0;
        for(int n:nums)
            if(n==0)    c0++;
            else if(n==1)   c1++;
            else    c2++;
        while(c0+c1+c2>0) {
            if(c0>0) {
                nums[i++]=0;
                c0--;
            }
            else if(c1>0) {
                nums[i++]=1;
                c1--;
            }
            else {
                nums[i++]=2;
                c2--;
            }
        }
    }
}

// Using one-pass instead of two pass
// t.c.=O(n), s.c.=O(1)
class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int c=0, l=0, h=n-1;
        while(c<=h) {
            if(nums[c]==0) {
                int temp=nums[c];
                nums[c]=nums[l];
                nums[l]=temp;
                c++; l++;
            }
            else if(nums[c]==2) {
                int temp=nums[c];
                nums[c]=nums[h];
                nums[h]=temp;
                h--;
            }
            else    
                c++;
        }
    }
}
