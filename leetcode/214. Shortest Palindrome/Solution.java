// https://leetcode.com/problems/shortest-palindrome/description/
// using two pointers
// t.c.=O(n^2), s.c.=O(1)
class Solution {
    public String shortestPalindrome(String s) {
        int len=s.length(), k=len;
        StringBuilder sb=new StringBuilder();
        for(;k>0;k--)
            if(isPalindrome(s, 0, k-1)) {
                for(int i=len-1;i>=k;i--)
                    sb.append(s.charAt(i));
                sb.append(s);
                return sb.toString();
            }
        return s;
    }
    private boolean isPalindrome(String s, int start, int end) {
        while(start<end) 
            if(s.charAt(start++)!=s.charAt(end--))
                return false;
        return true;
    }
}

// using KMP
// t.c.=O(n), s.c.=O(n)
class Solution {
    public String shortestPalindrome(String s) {
        if(s.length()==0)   return s;
        String rev=new StringBuilder(s).reverse().toString();
        String combined=s+"#"+rev;
        int combinedLen=combined.length();
        int[] prefixTable=new int[combinedLen];
        for(int i=1;i<combinedLen;i++) {
            int length=prefixTable[i-1];
            while(length>0 && combined.charAt(i)!=combined.charAt(length))
                length=prefixTable[length-1];
            if(combined.charAt(i)==combined.charAt(length))
                length++;
            prefixTable[i]=length;
        }
        int prefixPalindromeLen=prefixTable[combinedLen-1];
        String suffix=s.substring(prefixPalindromeLen);
        return new StringBuilder(suffix).reverse().toString()+s;
    }
}
