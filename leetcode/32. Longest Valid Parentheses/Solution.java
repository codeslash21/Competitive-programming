// using bruteforce method
// t.c.=O(n^3), s.c.=O(n)
class Solution {
    public boolean isValid(String s, int start, int end) {
        Stack<Character> stack = new Stack<>();
        for(int i=start;i<end;i++) {
            if(s.charAt(i)=='(')
                stack.push(s.charAt(i));
            else if(!stack.isEmpty() && stack.peek()=='(')
                stack.pop();
            else
                return false;
        }
        return stack.isEmpty();
    }
    public int longestValidParentheses(String s) {
        int n=s.length(), maxLen=0;
        for(int i=2;i<=n;i+=2)
            for(int j=0;j<=n-i;j++)
                if(isValid(s, j, j+i))
                    maxLen=Math.max(maxLen, i);
        return maxLen;
    }
}

// using dp
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int longestValidParentheses(String s) {
        int n=s.length(), maxLen=0;
        int[] dp = new int[n];
        for(int i=1;i<n;i++)
            if(s.charAt(i)==')') {
                if(s.charAt(i-1)=='(')
                    dp[i]=(i>=2?dp[i-2]:0)+2;
                else if(i-dp[i-1]>0 && s.charAt(i-1-dp[i-1])=='(')
                    dp[i]=dp[i-1]+2+(i-dp[i-1]>=2?dp[i-2-dp[i-1]]:0);
                maxLen=Math.max(maxLen, dp[i]);
            }
        return maxLen;
    }
}

// using stack
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int longestValidParentheses(String s) {
        int n=s.length(), maxLen=0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i=0;i<n;i++)
            if(s.charAt(i)=='(')
                stack.push(i);
            else {
                stack.pop();
                if(stack.isEmpty())
                    stack.push(i);
                else
                    maxLen=Math.max(maxLen, i-stack.peek());
            }
        return maxLen;
    }
}

// Without using extra space
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int longestValidParentheses(String s) {
        int n=s.length(), left=0, right=0, maxLen=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='(')
                left++;
            else
                right++;
            if(left==right)
                maxLen=Math.max(maxLen, 2*right);
            else if(right>left)
                left=right=0;
        }
        left=right=0;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='(')
                left++;
            else
                right++;
            if(left==right)
                maxLen=Math.max(maxLen, 2*right);
            else if(left>right)
                left=right=0;
        }
        return maxLen;
    }
}
