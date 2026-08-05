// https://leetcode.com/problems/length-of-last-word/description/
class Solution {
    public int lengthOfLastWord(String s) {
        s=s.trim();
        return s.length()-s.lastIndexOf(" ")-1;
    }
}
