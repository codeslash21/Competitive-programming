// Using sorting and hashmap
// t.c.=O(nlogn) s.c.=O(n)
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] num = new int[n];
        for(int i=0;i<n;i++)
            num[i]=nums[i];
        HashMap<Integer, Integer> hash_table = new HashMap<>();
        Arrays.sort(num);
        
        for(int i=0;i<n;i++)
            hash_table.put(num[i], hash_table.getOrDefault(num[i],-1)==-1?i:hash_table.get(num[i]));

        for(int i=0;i<n;i++)
            res[i]=hash_table.get(nums[i]);
        return res;
    }
}

// Using extra array
// t.c.=O(n) s.c.=O(1)
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n=nums.length;
        int[] num = new int[101];
        int[] res = new int[n];
        for(int i:nums)
            num[i]+=1;
        for(int i=1;i<101;i++)
            num[i]+=num[i-1];
        for(int i=0;i<n;i++) {
            if(nums[i]==0)
                res[i]=0;
            else
                res[i]=num[nums[i]-1];
        }
        return res;
    }
}
