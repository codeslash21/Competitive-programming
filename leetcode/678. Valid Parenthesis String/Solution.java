// https://leetcode.com/problems/valid-parenthesis-string/submissions/2037227967/
// using recursion
// t.c.=O(3^n), s.c.=O(n)
class Solution {
    public boolean checkValidString(String s) {
        return solve(s, 0, 0);
    }
    private boolean solve(String s, int index, int openCount) {
        if(openCount<0) return false;
        if(index==s.length())   return openCount==0;
        char ch=s.charAt(index);
        if(ch=='(')
            return solve(s, index+1, openCount+1);
        else if(ch==')')
            return solve(s, index+1, openCount-1);
        else
            return solve(s, index+1, openCount+1) ||
                   solve(s, index+1, openCount-1) ||
                   solve(s, index+1, openCount);
    }
}

// using dp
// t.c.=O(n^2), s.c.=O(n^2)
class Solution {
    public boolean checkValidString(String s) {
        int len=s.length();
        // memo[i][j] = 0 (unvisited), 1 (true), -1 (false)
        int[][] memo=new int[len+1][len+1];
        return solve(s, 0, 0, memo);
    }
    private boolean solve(String s, int index, int openCount, int[][] memo) {
        if(openCount<0) return false;
        if(index==s.length())   return openCount==0;
        if(memo[index][openCount]!=0)   return memo[index][openCount]==1;
        boolean result=false;
        char ch=s.charAt(index);
        if(ch=='(')
            result=solve(s, index+1, openCount+1, memo);
        else if(ch==')')
            result=solve(s, index+1, openCount-1, memo);
        else
            result=solve(s, index+1, openCount+1, memo) ||
                   solve(s, index+1, openCount-1, memo) ||
                   solve(s, index+1, openCount, memo);
        memo[index][openCount]=result?1:-1;
        return result;
    }
}

// using greedy technique
// t.c.=O(n), s.c.=O(1)
class Solution {
    public boolean checkValidString(String s) {
        int low=0, high=0, len=s.length();
        for(int i=0;i<len;i++) {
            char ch=s.charAt(i);
            if(ch=='(') {
                low++;  high++;
            } else if(ch==')') {
                low--;  high--;
            } else {
                low--;  high++;
            }
            if(high<0)  // Even the most optimistic case has too many ')'
                return false;
            low=Math.max(low, 0);   // Open count can't go negative; clamp minimum
        }
        // Valid if zero is within the range of possible open counts
        return low==0;
    }
}
