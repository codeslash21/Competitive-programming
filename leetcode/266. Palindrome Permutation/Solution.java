// using array
// t.c.=O(n), s.c.=O(1)
class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] freq = new int[26];
        for(char c:s.toCharArray())
            freq[c-'a']++;
        int cnt=0;
        for(int num:freq)
            if(num%2!=0)
                cnt++;
        return cnt<2;
    }
}
