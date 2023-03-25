// Using two pointers technique
// t.c.=O9n), s.c.=O(1)
class Solution {
    public void reverseString(char[] s) {
        int n=s.length;
        int start=0, end=n-1;
        while(start<end) {
            char temp = s[start];
            s[start++]=s[end];
            s[end--]=temp;
        }
    }
}
