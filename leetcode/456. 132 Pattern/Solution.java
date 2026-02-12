// https://leetcode.com/problems/132-pattern/description/
// using bruteforce
// t.c.=O(n^2), s.c.=O(1)
class Solution {
    public boolean find132pattern(int[] nums) {
        int len=nums.length, min=nums[0];
        for(int j=1;j<len-1;j++) {
            min=Math.min(min, nums[j]);
            if(min==nums[j])
                continue;
            for(int k=j+1;k<len;k++)
                if(nums[k]>min && nums[k]<nums[j])
                    return true;
        }
        return false;
    }
}

// searching intervals
// t.c.=O(n^2), s.c.=O(n)
class Solution {
    public boolean find132pattern(int[] nums) {
        List<int[]> ranges=new ArrayList<>();
        int len=nums.length, i=0,j=1;
        for(j=1;j<len;j++) {
            if(nums[j-1]>nums[j]) {
                if(i<j-1)
                    ranges.add(new int[]{nums[i], nums[j-1]});
                i=j;
            }
            for(int[] range:ranges)
                if(range[0]<nums[j] && nums[j]<range[1])
                    return true;
        }
        return false;
    }
}

//  using stack
// t.c.=O(n), s.c.=O(n)
class Solution {
    public boolean find132pattern(int[] nums) {
        int len=nums.length;
        int[] min=new int[len];
        Stack<Integer> stack=new Stack<>();
        min[0]=nums[0];
        for(int i=1;i<len;i++)
            min[i]=Math.min(nums[i], min[i-1]);
        for(int j=len-1;j>0;j--) {
            if(nums[j]>min[j]) {
                while(!stack.isEmpty() && min[j]>=stack.peek())
                    stack.pop();
                if(!stack.isEmpty() && nums[j]>stack.peek())
                    return true;
                stack.push(nums[j]);
            }
        }
        return false;
    }
}
