// Using sorting technique
// t.c.=O(nlogn), s.c.=O(logn), as in Java sort() is implemented using variation of quick sort and its s.c.=O(logn)
class Solution {
    public int findDuplicate(int[] nums) {
        int n=nums.length-1;
        Arrays.sort(nums);
        for(int i=0;i<n;i++)
            if(nums[i]==nums[i+1])
                return nums[i];
        return -1; 
    }
}

// Using Set
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<Integer>();
        for(int num:nums) {
            if(seen.contains(num))
                return num;
            seen.add(num);
        }
        return -1; 
    }
}

// Flipping sign of the number
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int findDuplicate(int[] nums) {
        int duplicate=-1;
        for(int num:nums) {
            int cur=Math.abs(num);
            if(nums[cur]<0) {
                duplicate=cur;
                break;
            }
            nums[cur]*=-1;
        }
        for(int i=0;i<nums.length;i++)
            nums[i]=Math.abs(nums[i]);
        return duplicate;
    }
}

// Using array as hashmap iterative approach
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int findDuplicate(int[] nums) {
        int cur=nums[0];
        while(cur!=nums[cur]) {
            int temp=nums[cur];
            nums[cur]=cur;
            cur=temp;
        }
        return cur;
    }
}

// Using array as hashmap recursive approach
// t.c.=O(n), s.c.=O(n), bcz of recursion stack
class Solution {
    public int store(int[] nums, int cur) {
        if(cur==nums[cur])
            return cur;
        int temp=nums[cur];
        nums[cur]=cur;
        return store(nums, temp);
    }
    public int findDuplicate(int[] nums) {
        return store(nums, nums[0]);
    }
}

// Using Floyd's tortoise and hare algo
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int findDuplicate(int[] nums) {
        int tortoise=nums[0], hare=nums[0];
        do{
            tortoise=nums[tortoise];
            hare=nums[nums[hare]];
        } while(tortoise!=hare);
        tortoise=nums[0];
        while(tortoise!=hare) {
            tortoise=nums[tortoise];
            hare=nums[hare];
        }
        return hare;
    }
}
