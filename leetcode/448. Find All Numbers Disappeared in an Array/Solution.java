// Using linear scan
// t.c.=O(n), s.c.=O(n);
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n=nums.length;
        List<Integer> result = new ArrayList<>();
        int[] arr = new int[n+1];
        Arrays.fill(arr, 0);
        for(int i=0;i<n;i++)
            arr[nums[i]]+=1;
        for(int i=1;i<=n;i++)
            if(arr[i]==0)
                result.add(i);
        return result;
    }
}

// Using hashmap
// t.c.=O(n), s.c.=O(n)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n=nums.length;
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Boolean> hashtable = new HashMap<Integer, Boolean>();
        for(int i=0;i<n;i++)
            hashtable.put(nums[i], true);
        for(int i=1;i<=n;i++)
            if(!hashtable.containsKey(i))
                result.add(i);
        return result;
    }
}

// By changing the magnitude of the numbers
// t.c.==O(n), s.c.=O(1)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n=nums.length;
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<n;i++) {
            int ind=Math.abs(nums[i])%n;
            if(nums[ind]>0)
                nums[ind]*=-1;
        }
        for(int i=1;i<n;i++)
            if(nums[i]>0)
                result.add(i);
        if(nums[0]>0)
            result.add(n);
        return result;
    }
}
