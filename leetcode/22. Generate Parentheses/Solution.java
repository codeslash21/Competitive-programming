// Usinng bruteforce method
// t.c.=O((2^2n)*n), s.c.=O((2^2n)*n)
class Solution {
    private boolean isValid(String s) {
        int leftCnt=0;
        for(char c:s.toCharArray()) {
            if(c=='(')
                leftCnt++;
            if(c==')')
                leftCnt--;
            if(leftCnt<0)
                return false;
        }
        return leftCnt==0;
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer("");
        while(!queue.isEmpty()) {
            String curr = queue.poll();
            if(curr.length()==2*n) {
                if(isValid(curr))
                    result.add(curr);
                continue;
            }
            queue.offer(curr+"(");
            queue.offer(curr+")");
        }
        return result;
    }
}

// using backtracking
// t.c.=O((2^2n)*n), s.c.=O(n)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }
    private void backtrack(List<String> result, StringBuilder str, int leftCnt, int rightCnt, int n) {
        if(str.length()==2*n) {
            result.add(str.toString());
            return;
        }
        if(leftCnt<n) {
            str.append('(');
            backtrack(result, str, leftCnt+1, rightCnt, n);
            str.deleteCharAt(str.length()-1);
        }
        if(leftCnt>rightCnt) {
            str.append(')');
            backtrack(result, str, leftCnt, rightCnt+1, n);
            str.deleteCharAt(str.length()-1);
        }
    }
}
