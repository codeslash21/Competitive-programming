// https://leetcode.com/problems/numbers-at-most-n-given-digit-set/description/
// t.c.=O(l*d), s.c.=O(l)
class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String num=String.valueOf(n);
        int l=num.length(), count=0, d=digits.length;
        // case 1: count number with digits less than l
        for(int i=1;i<l;i++)
            count+=Math.pow(d, i);
        // case 2: count number with digits equal to l
        for(int i=0;i<l;i++) {
            boolean match=false;
            for(String digit:digits) {
                if(digit.charAt(0)<num.charAt(i)) 
                    count+=Math.pow(d, l-1-i);
                else if(digit.charAt(0)==num.charAt(i))
                    match=true;
            }
            if(!match)  return count;
        }
        // if we match every digit of n, then n itself is valid
        count++;
        return count;
    }
}
