// Using cumulative sum
// t.c.=O(n^2), s.c.=O(n)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length, cnt=0;
        int[] sum = new int[n+1];
        sum[0]=0;
        for(int i=1;i<=n;i++)
            sum[i]=sum[i-1]+nums[i-1];
        for(int i=1;i<=n;i++)
            for(int j=i;j<=n;j++)
                if(sum[j]-sum[i-1]==k)
                    cnt++;
        return cnt;
    }
}

// Without using extra space
// t.c.=O(n^2), s.c.=O(n)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length, cnt=0;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=nums[j];
                if(sum==k)
                    cnt++;
            }
        }
        return cnt;
    }
}

// Using hashmap
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length, cnt=0, sum=0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i=0;i<n;i++) {
            sum+=nums[i];
            if(map.containsKey(sum-k))
                cnt+=map.get(sum-k);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return cnt;
    }
}
