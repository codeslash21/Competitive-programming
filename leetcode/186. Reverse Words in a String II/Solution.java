// Reverse technique
// t.c.=O(n), s.c.=O(1)
class Solution {
    public void reverse(char[] s, int start, int end) {
        while(start<end) {
            char temp=s[start];
            s[start++]=s[end];
            s[end--]=temp;
        }
    }
    public void reverseWords(char[] s) {
        int n=s.length;
        reverse(s, 0, n-1);
        int start=0, end=0;
        while(start<n) {
            while(end<n && s[end]!=' ') end++;
            reverse(s, start, end-1);
            end++;
            start=end;
        }
    }
}
