// https://leetcode.com/problems/greatest-common-divisor-of-strings/description/
// using bruteforce
// t.c.=O(min(m,n)*(m+n)), s.c.=O(m+n)
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int len1=str1.length(), len2=str2.length(), minLen=Math.min(len1, len2);
        for(int i=minLen;i>0;i--) {
            if(len1%i!=0 || len2%i!=0)  continue;
            String gcd=str1.substring(0, i);
            if(divide(str1, gcd) && divide(str2, gcd))
                return gcd;
        }
        return "";
    }
    private boolean divide(String s, String gcd) {
        int repeat=s.length()/gcd.length();
        StringBuilder sb=new StringBuilder();
        while(repeat-->0)
            sb.append(gcd);
        return sb.toString().equals(s);
    }
}

// using gcd
// t.c.=O(m+n), s.c.=O(m+n)
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // If both strings share a common divisor, their concatenations must be equal
        if(!(str1+str2).equals(str2+str1))   return "";
        int gcdLen=gcd(str1.length(), str2.length());
        return str1.substring(0, gcdLen);
    }
    private int gcd(int a, int b) {
        while(b!=0) {
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}
