// Using dp iterative approach
// t.c.=O(n*m*k), s.c.=O(n), n is length of string, m=number of word in dict, k=avg length of each word
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n];
        for(int i=0;i<n;i++)
            for(String word:wordDict) {
                if(i<word.length()-1)
                    continue;
                if(i==word.length()-1 || dp[i-word.length()])
                    if(s.substring(i-word.length()+1, i+1).equals(word)) {
                        dp[i]=true;
                        break;
                    }
            }
        return dp[n-1];
    }
}
