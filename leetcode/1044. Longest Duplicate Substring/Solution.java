// https://leetcode.com/problems/longest-duplicate-substring/description/
// t.c.=O(nlogn), s.c.=O(n)
class Solution {
    private long base=26, mod=1_000_000_007;
    public String longestDupSubstring(String s) {
        int n=s.length(), left=1, right=n-1;
        String result="";
        // binary search to find best possible lenght
        while(left<=right) {
            int mid=left+(right-left)/2;
            String duplicate=rabinKarp(s, mid);
            if(duplicate!=null) {
                result=duplicate;
                left=mid+1; // check longer length
            } else
                right=mid-1; // check shorter length
        }
        return result;
    }
    private String rabinKarp(String s, int len) {
        long hash=0, power=1;
        Map<Long, List<Integer>> seen=new HashMap<>();
        // compute the hash for fist window and base^len
        for(int i=0;i<len;i++) {
            hash=(hash * base + (s.charAt(i)-'a'))%mod;
            power=(power*base)%mod;
        }
        seen.computeIfAbsent(hash, k->new ArrayList<>()).add(0);
        for(int i=1;i<=s.length()-len;i++) {
            hash=(hash * base 
                - ((s.charAt(i-1)-'a') * power) % mod
                + mod // to handle negative hash
                + (s.charAt(i+len-1)-'a')) % mod;
            List<Integer> indices=seen.get(hash);
            if(indices!=null) {
                String candidate=s.substring(i, i+len);
                for(int index:indices)
                    if(s.substring(index, index+len).equals(candidate))
                        return candidate;
            }
            seen.computeIfAbsent(hash, k->new ArrayList<>()).add(i);
        }
        return null;
    }
}
