// Using map
// t.c.=O(n), s.c.=O(n)
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n=nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            if(map.getOrDefault(nums[i], -1)>=0)
                if(i-map.get(nums[i])<=k)   return true;
            map.put(nums[i], i);
        }
        return false;
    }
}

// Using self balancing bst
// t.c.=O(nlog(min(n,k))), s.c.=O(min(n,k))
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n=nums.length;
        Set<Integer> set = new TreeSet<>();
        for(int i=0;i<n;i++) {
            if(set.contains(nums[i]))
                return true;
            set.add(nums[i]);
            if(set.size()>k)
                set.remove(nums[i-k]);
        }
        return false;
    }
}

// Using set
// t.c.=O(n), s.c.=O(min(n,k))
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n=nums.length;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++) {
            if(set.contains(nums[i])) return true;
            set.add(nums[i]);
            if(set.size()>k)
                set.remove(nums[i-k]);
        }
        return false;
    }
}

