// https://leetcode.com/problems/reverse-integer/description/
// t.c.=O(logN), s.c.+O(1)
class Solution {
    public int reverse(int x) {
        int rev=0, maxValue=Integer.MAX_VALUE, minValue=Integer.MIN_VALUE;
        while(x!=0) {
            int pop=x%10;
            x/=10;
            if(rev>maxValue/10 || (rev==maxValue/10 && pop>7))
                return 0;
            else if(rev<minValue/10 || (rev==minValue/10 && pop<-8))
                return 0;
            rev=rev*10+pop;
        }
        return rev;
    }
}
