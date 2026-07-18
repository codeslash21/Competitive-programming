// https://leetcode.com/problems/longest-happy-prefix/description/
// using KMP
// t.c.=O(n), s.c.=O(n)
class Solution {
    public String longestPrefix(String s) {
        int n=s.length();
        int[] prefixTable=new int[n];
        for(int i=1;i<n;i++) {
            int length=prefixTable[i-1];
            while(length>0 && s.charAt(i)!=s.charAt(length))
                length=prefixTable[length-1];
            if(s.charAt(length)==s.charAt(i))
                length++;
            prefixTable[i]=length;
        }
        return s.substring(0, prefixTable[n-1]);
    }
}
