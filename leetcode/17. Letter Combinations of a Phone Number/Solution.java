// using backtracking
// t.c.=O((4^n)*n), s.c.=O(n), because of recursion stack
class Solution {
    int n;
    List<String> res = new ArrayList<>();
    Map<Character, String> map = Map.of(
        '2', "abc", '3', "def", '4', "ghi", '5', "jkl", 
        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    public List<String> letterCombinations(String digits) {
        n=digits.length();
        if(n==0)
            return res;
        backtrack(0, digits, new StringBuilder());
        return res;
    }
    private void backtrack(int idx, String digits, StringBuilder sb) {
        if(sb.length()==n) {
            res.add(sb.toString());
            return;
        }
        for(char c:map.get(digits.charAt(idx)).toCharArray()) {
            sb.append(c);
            backtrack(idx+1, digits, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
