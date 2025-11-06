// Using brute force method
// t.c. =O(n), s.c.=O(n)
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n=nums.length;
        int[] odd = new int[n];
        int[] even = new int[n];
        int o=0, e=0, j=0;
        for(int i=0;i<n;i++) {
            if(nums[i]%2==0)
                even[e++]=nums[i];
            else   
                odd[o++]=nums[i];
        }
        for(int i=0;i<e;i++) 
            nums[j++]=even[i];
        for(int i=0;i<o;i++)
            nums[j++]=odd[i];
        return nums;
    }
}

// Using sorting with custom comparator
// t.c.=O(nlogn) s.c.=O(n)
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n=nums.length;
        Integer[] num = new Integer[n];
        for(int i=0;i<n;i++)
            num[i]=nums[i];
        Arrays.sort(num, (a,b)->Integer.compare(a%2, b%2));
        for(int i=0;i<n;i++)
            nums[i]=num[i];
        return nums;
         /* Alternative:
        return Arrays.stream(A)
                     .boxed()
                     .sorted((a, b) -> Integer.compare(a%2, b%2))
                     .mapToInt(i -> i)
                     .toArray();
        */
    }
}

// Using two pointers
// t.c.=O(n) s.c.=O(1)
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int len=nums.length, idx1=0, idx2=0;
        for(;idx2<len;idx2++) 
            if(nums[idx2]%2==0) {
                int num=nums[idx1];
                nums[idx1++]=nums[idx2];
                nums[idx2]=num;
            }
        return nums;
    }
}
