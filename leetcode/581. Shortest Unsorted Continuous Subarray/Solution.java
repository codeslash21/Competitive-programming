// Using bruteforce method, selection sort method
//t.c.=O(n^2), s.c.=O(1)
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n=nums.length;
        int start=n, end=-1;
        for(int i=0;i<n-1;i++) {
            for(int j=i+1;j<n;j++)
                if(nums[i]>nums[j]) {
                    start=Math.min(start, i);
                    end=Math.max(end, j);
                }
        }
        if(start==n)
            return 0;
        else return (end-start+1);
    }
}


// Using sorting
// t.c.=O(nlogn), s.c.=O(n)
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n=nums.length;
        int[] cnums=nums.clone();
        Arrays.sort(cnums);
        int start=n, end=0;
        for(int i=0;i<n;i++) 
            if(cnums[i]!=nums[i]) {
                start=Math.min(start, i);
                end=Math.max(end, i);
            }
        return(end-start>0?end-start+1 : 0);
    }
}

