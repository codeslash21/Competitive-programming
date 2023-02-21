// Using brute-force method
// t.c.=O(n^2) s.c.=O(n)
class Solution {
    public int singleNumber(int[] nums) {
        List<Integer> no_dup = new ArrayList<>();
        for(int i:nums) {
            if(!no_dup.contains(i)) 
                no_dup.add(i);
            else 
                no_dup.remove(new Integer(i));
        }
        return no_dup.get(0);
    }
}

// Using hash map
// t.c.=O(n) s.c.=O(n)
class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hash_table = new HashMap<>();
        for(int i : nums) 
            hash_table.put(i, hash_table.getOrDefault(i, 0)+1);
        for(int i : nums)  
            if(hash_table.get(i)%2==1)
                return i;
        return 0;
    }
}

// Using set and math
// t.c.=O(n) s.c.=O(n)
class Solution {
    public int singleNumber(int[] nums) {
        int sumOfSet=0, sumOfNums=0;
        Set<Integer> set = new HashSet<>();
        for(int i: nums) {
            if(!set.contains(i)) {
                set.add(i);
                sumOfSet += i;
            }
            sumOfNums += i;
        }
        return 2*sumOfSet - sumOfNums;
    }
}

// Using XOR concepts
// t.c.=O(n) s.c.=O(1)
class Solution {
    public int singleNumber(int[] nums) {
        int a = 0;
        for(int i:nums) 
            a^=i;
        return a;
    }
}
