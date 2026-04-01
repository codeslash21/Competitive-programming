// https://leetcode.com/problems/is-subsequence/description/
// t.c.=O(n), s.c.=O(1)
class Solution {
    public boolean isSubsequence(String s, String t) {
        int lenS=s.length(), lenT=t.length(), idxS=0, idxT=0;
        while(idxS<lenS && idxT<lenT) {
            if(s.charAt(idxS)==t.charAt(idxT))
                idxS++;
            idxT++;
        }
        return idxS==lenS;
    }
}
