// Using extra array
// t.c.=O(n), s.c.=O(n)
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n=nums.length;
        List<Integer> arr = new ArrayList<>();
        int[] freq = new int[n+1];
        Arrays.fill(freq, 0);
        for(int num:nums)
            freq[num]+=1;
        for(int i=1;i<=n;i++)
            if(freq[i]>1)
                arr.add(i);
        return arr;
    }
}

// Flipping the magnitude of the numbers
// t.c.=O(n), s.c.=O(1)
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n=nums.length;
        List<Integer> arr = new ArrayList<>();
        for(int i=0;i<n;i++) {
            int ind = Math.abs(nums[i])-1;
            if(nums[ind]<0)
                arr.add(ind+1);
            else
                nums[ind]*=-1;
        }
        return arr;
    }
}
