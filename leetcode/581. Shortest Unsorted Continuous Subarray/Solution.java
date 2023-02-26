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

// Using stack
// t.c.=O(n) s.c.=O(n)
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n=nums.length;
        Stack<Integer> stack = new Stack<Integer>();
        int start=n, end=0;
        for(int i=0;i<n;i++) {
            while(!stack.isEmpty() && nums[stack.peek()]>nums[i])
                start = Math.min(start, stack.pop());
            stack.push(i);
        }
        stack.clear();
        for(int i=n-1;i>=0;i--) {
            while(!stack.isEmpty() && nums[stack.peek()]<nums[i])
                end=Math.max(end, stack.pop());
            stack.push(i);
        }
        return end-start<0? 0:end-start+1;
    }
}

// Without stack but same concepts
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n=nums.length;
        int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
        int start, end;
        for(int i=1;i<n;i++) 
            if(nums[i]<nums[i-1])
                min=Math.min(min, nums[i]);
        for(int i=n-2;i>=0;i--)
            if(nums[i]>nums[i+1])
                max=Math.max(max, nums[i]);
        for(start=0;start<n;start++) 
            if(min<nums[start])
                break;
        for(end=n-1;end>=0;end--)
            if(max>nums[end])
                break;
        return end-start<0? 0:end-start+1;
    }
}
