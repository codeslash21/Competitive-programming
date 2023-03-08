// Using sorting
// t.c.=O(nlogn), s.c.=O(1)
class Solution {
    public int singleNumber(int[] nums) {
        int n=nums.length, i=0;
        Arrays.sort(nums);
        for(i=0;i<n-1;i=i+3)
            if(nums[i]!=nums[i+1])
                return nums[i];
        return nums[i];
    }
}

// Using hashmap
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int singleNumber(int[] nums) {
        int n=nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num:nums) 
            map.put(num, map.getOrDefault(num, 0)+1);
        for(int k:map.keySet())
            if(map.get(k)==1)
                return k;
        return -1;
    }
}

// Using set
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set=new HashSet<>();
        long setSum=0, arraySum=0;
        for(int n:nums) {
            arraySum+=n;
            set.add(n);
        }
        for(int s:set)  setSum+=s;
        return (int)((3*setSum-arraySum)/2);
    }
}

// Using bitwise xor, not, and
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int singleNumber(int[] nums) {
        int seenOnce=0, seenTwice=0;
        for(int num:nums) {
            seenOnce=~seenTwice & (seenOnce^num);
            seenTwice=~seenOnce & (seenTwice ^ num);
        }
        return seenOnce;
    }
}
