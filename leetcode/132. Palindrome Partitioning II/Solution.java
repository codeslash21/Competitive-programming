// https://leetcode.com/problems/palindrome-partitioning-ii/description/
// using recursion
// t.c.=O(2^m), s.c.=O(m)
class Solution {
    public int minCut(String s) {
        return dfs(s, 0);
    }
    private int dfs(String s, int start) {
        if(start==s.length())   return -1;
        int minCuts=s.length()-start-1;
        for(int end=start;end<s.length();end++)
            if(isPalindrome(s, start, end))
                minCuts=Math.min(minCuts, 1+dfs(s, end+1));
        return minCuts;
    }
    private boolean isPalindrome(String s, int start, int end) {
        while(start<=end) {
            if(s.charAt(start)!=s.charAt(end))  return false;
            start++;
            end--;
        }
        return true;
    }
}

// using dp
// t.c.=O(n^2), s.c.=O(n^2)
class Solution {
    public int minCut(String s) {
        int n=s.length();
        boolean[][] isPalindrome=new boolean[n][n];
        for (int i = n - 1; i >= 0; i--)
            for (int j = i; j < n; j++)
                if (s.charAt(i) == s.charAt(j) && (j-i<3 || isPalindrome[i+1][j-1]))
                    isPalindrome[i][j] = true;
        int[] cuts = new int[n];
        for (int i = 0; i < n; i++) {
            if (isPalindrome[0][i]) {
                cuts[i] = 0; // entire prefix is a palindrome
                continue;
            }
            cuts[i] = i; // worst case: cut every character
            for (int j = 1; j <= i; j++) 
                if (isPalindrome[j][i]) 
                    cuts[i] = Math.min(cuts[i], cuts[j - 1] + 1);
        }
        return cuts[n-1];
    }
}

// expand around center
// t.c.=O(n^2), s.c.=O(n)
class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] cuts = new int[n];
        // Initialize worst case: i cuts for prefix of length i+1
        for (int i = 0; i < n; i++) cuts[i] = i;
        for (int center = 0; center < n; center++) {
            // Odd-length palindromes
            expand(s, center, center, cuts);
            // Even-length palindromes
            expand(s, center, center + 1, cuts);
        }
        return cuts[n - 1];
    }
    private void expand(String s, int left, int right, int[] cuts) {
        int n=s.length();
        while(left>=0 && right<n && s.charAt(left)==s.charAt(right)) {
            if(left==0)
                cuts[right]=0;
            else
                cuts[right]=Math.min(cuts[right], 1+cuts[left-1]);
            left--;
            right++;
        }
    }
}
