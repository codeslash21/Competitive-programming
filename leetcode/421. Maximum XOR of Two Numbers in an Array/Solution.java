// https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/description/
// using bitwise prefix and hashset
// t.c.=O(31*n)=O(n), s.c.=O(n)
class Solution {
    public int findMaximumXOR(int[] nums) {
        int maxXOR=0;
        for(int k=30;k>=0;k--) {
            int candidate=maxXOR | (1<<k), candidatePrefix=candidate>>k;
            Set<Integer> prefixes=new HashSet<>();
            boolean found=false;
            for(int num:nums)
                prefixes.add(num>>k);
            for(int prefix:prefixes)
                if(prefixes.contains(prefix^candidatePrefix)) {
                    found=true;
                    break;
                }
            if(found)
                maxXOR=candidate;
        }
        return maxXOR;
    }
}
