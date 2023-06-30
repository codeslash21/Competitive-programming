// using counter and one pass
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int majorityElement(int[] nums) {
        int cnt=0;
        Integer candidate = null;
        for(int num:nums) {
            if(cnt==0)
                candidate=num;
            cnt+=candidate==num?1:-1;
        }
        return candidate;
    }
}

// Using bit manipulation\
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int majorityElement(int[] nums) {
        int bit=1, candidate=0, n=nums.length;
        for(int i=0;i<32;i++) {
            bit=1<<i;
            int bitCnt=0;
            for(int num:nums)
                if((num & bit)>0)
                    bitCnt++;
            if(bitCnt>n/2)
                candidate+=bit;
        }
        return candidate;
    }
}
