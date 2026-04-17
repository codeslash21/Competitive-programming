// https://leetcode.com/problems/palindrome-partitioning/
// using backtracking
// t.c.=O(n*2^n), s.c.=O(n)
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), res);
        return res;
    }
    private void backtrack(String s, int start, List<String> current, List<List<String>> res) {
        if(start==s.length()) {
            res.add(new ArrayList<>(current));
            return;
        }
        for(int end=start;end<s.length();end++) {
            if(isPalindrome(s, start, end)) {
                current.add(s.substring(start, end+1));
                backtrack(s, end+1, current, res);
                current.remove(current.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s, int start, int end) {
        boolean isPalindrome=true;
        while(start<end) 
            if(s.charAt(start++)!=s.charAt(end--)) {
                isPalindrome=false;
                break;
            }
        return isPalindrome;
    }
}

// using dp
// t.c.=O(n^2 + n*2^n), s.c.=O(n*2^n)
class Solution {
    public List<List<String>> partition(String s) {
        int strLen=s.length();
        boolean[][] isPalindrome=new boolean[strLen][strLen];
        for(int len=1;len<=strLen;len++) 
            for(int i=0;i<=strLen-len;i++) {
                int j=i+len-1;
                if(s.charAt(i)==s.charAt(j))
                    isPalindrome[i][j]=(len<=2)||isPalindrome[i+1][j-1];
            }
        List<List<String>>[] dp=new List[strLen+1];
        dp[strLen]=new ArrayList<>();
        dp[strLen].add(new ArrayList<>());
        // build from right to left;
        for(int i=strLen-1;i>=0;i--) {
            dp[i]=new ArrayList<>();
            for(int j=i;j<strLen;j++) {
                if(isPalindrome[i][j]) {
                    String prefix=s.substring(i, j+1);
                    for(List<String> suffix:dp[j+1]) {
                        List<String> partition=new ArrayList<>();
                        partition.add(prefix);
                        partition.addAll(suffix);
                        dp[i].add(partition);
                    }
                }
            }
        }
        return dp[0];
    }
}
