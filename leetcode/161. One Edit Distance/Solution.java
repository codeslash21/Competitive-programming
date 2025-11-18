// https://leetcode.com/problems/one-edit-distance/description/
// using one pass
// t.c.=O(n), s.c.=O(n)
class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int lenS=s.length(), lenT=t.length();
        if(lenS>lenT)
            return isOneEditDistance(t, s);
        if(lenT-lenS>1)
            return false;
        for(int i=0;i<lenS;i++) {
            if(s.charAt(i)!=t.charAt(i))
                if(lenS==lenT)
                    return s.substring(i+1).equals(t.substring(i+1));
                else
                    return s.substring(i).equals(t.substring(i+1));
        }
        return lenS+1==lenT;
    }
}
