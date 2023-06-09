// using dp
// t.c.=O(n^2*k), s.c.=O(n^2*k)
class Solution {
    Map<Integer, Integer> memo = new HashMap<>();
    Set<Integer> set = Set.of(1, 9, 99);
    public int getLengthOfOptimalCompression(String s, int k) {
        return dp(s, 0, (char)('a'+26), 0, k);
    }
    private int dp(String s, int idx, int lastChar, int lastCnt, int k) {
        if(k<0)
            return Integer.MAX_VALUE/2;
        if(idx==s.length())
            return 0;
        int key = idx*107*107*27 + (lastChar-'a')*107*107 + lastCnt*107 + k;
        if(memo.containsKey(key))
            return memo.get(key);
        int keepChar;
        int deleteChar = dp(s, idx+1, lastChar, lastCnt, k-1);
        if(s.charAt(idx)==lastChar)
            keepChar=dp(s, idx+1, lastChar, lastCnt+1, k)+(set.contains(lastCnt)?1:0);
        else
            keepChar = dp(s, idx+1, s.charAt(idx), 1, k) + 1;
        int res = Math.min(keepChar, deleteChar);
        memo.put(key, res);
        return res;
    }
}
