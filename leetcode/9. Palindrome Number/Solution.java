// By reverting half of the number
// t.c.=O(logn), s.c.=O(1)
class Solution {
    public boolean isPalindrome(int x) {
        if(x<0 || (x%10==0 && x!=0))
            return false;
        int revert=0;
        while(x>revert) {
            revert=revert*10+x%10;
            x/=10;
        }
        return x==revert || x==revert/10;
    }
}
