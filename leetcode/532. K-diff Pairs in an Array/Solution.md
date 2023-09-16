// using sorting
// t.c.=O(nlogn), s.c.=O(logn)
class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int i=0,j=1, cnt=0;
        while(i<n && j<n) {
            if(i==j || nums[j]-nums[i]<k)
                j++;
            else if(nums[j]-nums[i]>k)
                i++;
            else {
                cnt++;
                j++;
                while(j<n && nums[j]==nums[j-1])
                    j++;
            }
        }
        return cnt;
    }
}

// using hashmap
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int cnt=0;
        for(int n:nums) {
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        for(Map.Entry<Integer, Integer> entry:map.entrySet()) {
            int key=entry.getKey(), value=entry.getValue();
            if(k>0 && map.containsKey(key+k))
                cnt++;
            else if(k==0 && value>1)
                cnt++;
        }
        return cnt;
    }
}
