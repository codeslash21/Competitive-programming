// using two pointers
// t.c.=O(n), s.c.=O(1)
class Solution {
    int cnt=0;
    public boolean check(String s, int start, int end) {
        while(start<end) {
            if(s.charAt(start)!=s.charAt(end))
                if(this.cnt++<1)
                    return check(s, start+1, end) || check(s, start, end-1);
                else
                    return false;
            start++;
            end--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        return check(s, 0, s.length()-1);
    }
}
