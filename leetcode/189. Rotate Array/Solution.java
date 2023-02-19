// Using Reversal technique
// T.C. = O(n) S.C. = O(1)
class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k%=n;
        reverse(nums, 0, n-k-1);
        reverse(nums, n-k, n-1);
        reverse(nums, 0, n-1);
    }
    public void reverse(int[] nums, int start, int end) {
        int temp=0;
        while(start<end) {
            temp = nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++; end--;
        }
    }
}

// Using cyclic replacement
// t.c.=O(n), s.c.=O(1)
class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k%=n;
        int count=0;
        for(int start=0;count<n;start++) {
            int curr_e = nums[start];
            int curr_i = start;
            do {
                int next = (curr_i + k)%n;
                int temp = nums[next];
                nums[next] = curr_e;
                curr_e = temp;
                curr_i = next;
                count++;
            } while(start!=curr_i);
        }
    }
}


// Using extra space
// t.c. = O(n), s.c.=O(k)
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int arr[] = new int[k];
        k%=n;
        int j=0;
        for(int i=n-k; i<n; i++) 
            arr[j++] = nums[i];
        for(int i=n-k-1;i>=0;i--) 
            nums[i+k] = nums[i];
        while(--j>=0)
            nums[j] = arr[j];
    }
}
