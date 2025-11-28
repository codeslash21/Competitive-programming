// https://leetcode.com/problems/removing-stars-from-a-string/
// using two pointers
// t.c.=O(n), s.c.=O(n)
class Solution {
    public String removeStars(String s) {
        char[] chars=s.toCharArray();
        int len=s.length(), left=1, right=1;
        while(right<len) {
            if(left>0 && chars[right]=='*')
                left--;
            else
                chars[left++]=chars[right];
            right++;
        }
        return new String(chars, 0, left);
    }
}
