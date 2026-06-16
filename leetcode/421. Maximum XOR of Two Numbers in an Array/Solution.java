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

// using trie
// t.c.=O(31*n)=O(n), s.c.=O(31*n)=O(n)
class Trie {
    Trie[] children;
    int count;
    public Trie() {
        children=new Trie[2];
        count=0;
    }
    public void insert(int[] nums) {
        for(int num:nums) {
            Trie node=this;
            for(int k=30;k>=0;k--) {
                int currBit=(num>>k)&1;
                if(node.children[currBit]==null)
                    node.children[currBit]=new Trie();
                node=node.children[currBit];
            }
        }
    }
}
class Solution {
    public int findMaximumXOR(int[] nums) {
        int maxXOR=0;
        Trie trie=new Trie();
        trie.insert(nums);
        // for each num find the max xor that we can get with other num
        for(int num:nums) {
            Trie node=trie;
            int currXOR=0;
            for(int k=30;k>=0;k--) {
                int currBit=(num>>k)&1, requiredBit=1-currBit;
                // to maximize xor we need two opposite bits
                // if requiredBit available then we move to that node
                if(node.children[requiredBit]!=null) {
                    currXOR|=(1<<k);
                    node=node.children[requiredBit];
                } else
                    node=node.children[currBit];
            }
            maxXOR=Math.max(maxXOR, currXOR);
        }
        return maxXOR;
    }
}
