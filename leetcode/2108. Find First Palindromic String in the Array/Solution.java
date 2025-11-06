// https://leetcode.com/problems/find-first-palindromic-string-in-the-array/description/
// two pointers
// t.c.=O(m*n), s.c.=O(1), n=len(words), m=maxLen(word)
class Solution {
    public boolean palindrome(String word) {
        int len=word.length(), left=0, right=len-1;
        while(left<right)
            if(word.charAt(left++)==word.charAt(right--))
                continue;
            else
                return false;
        return true;
    }
    public String firstPalindrome(String[] words) {
        for(String word:words)
            if(palindrome(word))
                return word;
        return "";
    }
}
