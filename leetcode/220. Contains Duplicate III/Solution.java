// Using bruteforce method
// t.c.=O(n*min(n,k)), s.c.=O(1)
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int n=nums.length;
        for(int i=0;i<n;i++) 
            for(int j=Math.max(0, i-indexDiff); j<i; j++) 
                if(Math.abs(nums[i]-nums[j])<=valueDiff)
                    return true;
        return false;
    }
}

// using self balancing bst and sliding window
// t.c.=O(n*log(min(n,k))), s.c.=O(min(n,k))
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int n=nums.length;
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0;i<n;i++) {
            Integer s = set.ceiling(nums[i]);
            if(s!=null && s-nums[i]<=valueDiff)
                return true;
            Integer p = set.floor(nums[i]);
            if(p!=null && nums[i]-p<=valueDiff)
                return true;
            set.add(nums[i]);
            if(set.size()>indexDiff)
                set.remove(nums[i-indexDiff]);
        }
        return false;
    }
}

// using bucket and sliding window
// t.c.=O(n), s.c.=O(min(n,k))
class Solution {
    public long getBucket(long value, long size) {
        return value<0? (value+1)/size-1 : value/size; 
    }
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int n=nums.length;
        Map<Long, Long> map = new HashMap<>();
        long size = (long) valueDiff+1;
        for(int i=0;i<n;i++) {
            long bucket = getBucket(nums[i], size);
            if(map.containsKey(bucket))
                return true;
            if(map.containsKey(bucket-1) && Math.abs(nums[i]-map.get(bucket-1))<size)
                return true;
            if(map.containsKey(bucket+1) && Math.abs(nums[i]-map.get(bucket+1))<size)
                return true;
            map.put(bucket, (long)nums[i]);
            if(i>=indexDiff)
                map.remove(getBucket(nums[i-indexDiff], size));
        }
        return false;
    }
}
