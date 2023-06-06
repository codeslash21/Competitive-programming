// using bruteforce method
// t.c.=O(n^2), s.c.=O(1)
class Solution {
    public boolean rotateString(String s, String goal) {
        int len1=s.length(), len2=goal.length();
        if(len1!=len2)
            return false;
        boolean res=false;
        for(int i=0;i<len1;i++) {
            String n = s.substring(i, len1)+s.substring(0,i);
            if(n.equals(goal)) {
                res=true;
                break;
            }
        }
        return res;
    }
}
