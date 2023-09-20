// using bruteforce technique
// t.c.=O(n^3), s.c.=O(1)
class Solution {
    public int minSubarray(int[] nums, int p) {
        int n=nums.length, rem=0;
        long sum=0;
        for(int num:nums)
                sum+=num;
        rem=(int)(sum%p);
        if(rem==0)
            return 0;
        for(int len=1; len<n; len++) {
            for(int i=0; i+len<=n; i++){
                sum=0;
                for(int j=i; j<i+len; j++)
                    sum+=nums[j];
                if(sum%p==rem)
                    return len;
            }
        }
        return -1;
    }
}

// using hashmap
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int minSubarray(int[] nums, int p) {
        int n=nums.length, rem=0, res=n;
        long sum=0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int num:nums)
            sum+=num;
        rem = (int)(sum%p);
        if(rem==0)
            return 0;
        sum=0;
        for(int i=0;i<n;i++) {
            sum+=nums[i];
            int currRem=(int)(sum%p);
            int requiredRem = currRem - rem;
            if(requiredRem<0)
                requiredRem=(requiredRem+p)%p;
            if(map.containsKey(requiredRem))
                res=Math.min(res, i-map.get(requiredRem));
            map.put(currRem, i);
        }
        return res==n?-1:res;
    }
}
