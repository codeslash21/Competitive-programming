// using prefix sum
// t.c.=O(n^2), s.c.=O(n)
class Solution {
    public int findMaxLength(int[] nums) {
        int n=nums.length, sum=0, res=0;
        int[] prefix = new int[n+1];
        for(int i=0;i<n;i++) {
            sum+=nums[i];
            prefix[i+1]=sum;
        }
        for(int size=n; size>0; size--) 
            for(int i=0;i+size-1<n; i++) 
                if(size%2==0 && prefix[i+size]-prefix[i]==size/2) {
                    res=size;
                    return res;
                }
        return res;
    }
}

// Using hashmap
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int cnt=0, n=nums.length, res=0;
        for(int i=0;i<n;i++) {
            if(nums[i]==1)
                cnt++;
            else 
                cnt--;
            if(map.containsKey(cnt))
                res=Math.max(res,i-map.get(cnt));
            else
                map.put(cnt, i);
        }
        return res;
    }
}
