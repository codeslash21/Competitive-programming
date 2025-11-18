// https://leetcode.com/problems/bag-of-tokens/description/
// using sorting + two pointers
// t.c.=O(nlogn), s.c.=O(logn)
class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int len=tokens.length, left=0, right=len-1, currScore=0, maxScore=0;
        Arrays.sort(tokens);
        while(left<=right) {
            if(power<tokens[left] && currScore==0)
                return maxScore;
            if(power<tokens[left]) {
                power+=tokens[right--];
                currScore--;
            } else {
                power-=tokens[left++];
                currScore++;
                maxScore=Math.max(maxScore, currScore);
            }
        }
        return maxScore;
    }
}
