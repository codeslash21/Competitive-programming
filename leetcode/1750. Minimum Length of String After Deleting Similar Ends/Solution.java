// https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/description/
// two pointers
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int minimumLength(String s) {
        int len=s.length(), left=0, right=len-1;
        while(left<right && s.charAt(left)==s.charAt(right)) {
            char ch=s.charAt(left);
            while(left<=right && s.charAt(left)==ch)
                left++;
            while(right>left && s.charAt(right)==ch)
                right--;

        }
        return right-left+1;
    }
}
