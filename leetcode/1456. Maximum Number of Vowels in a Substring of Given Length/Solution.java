// https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/
// sliding window
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int maxVowels(String s, int k) {
        int len=s.length(), right=0, currFreq=0, maxFreq=0;
        Set<Character> vowels=new HashSet<>(Arrays.asList('a','e','i','o','u'));
        while(right<len) {
            if(vowels.contains(s.charAt(right)))
                currFreq++;
            if(right>=k && vowels.contains(s.charAt(right-k)))
                currFreq--;
            maxFreq=Math.max(maxFreq, currFreq);
            right++;
        }
        return maxFreq;
    }
}
