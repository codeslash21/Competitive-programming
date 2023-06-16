// Using set and recursion
// t.c.=O(n^2), s.c.=O(n)
class Solution {
    public void helper(String s, int i, Set<String> dict, List<String> curr, List<String> res) {
        if(i==s.length()) {
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<curr.size();j++) {
                if(j>0)
                    sb.append(' ');
                sb.append(curr.get(j));
            }
            res.add(sb.toString());
            return;
        }
        for(int j=i+1;j<=s.length();j++) {
            if(dict.contains(s.substring(i,j))) {
                curr.add(s.substring(i,j));
                helper(s, j, dict, curr, res);
                curr.remove(curr.size()-1);
            }
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        List<String> res = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        helper(s, 0, dict, curr, res);
        return res;
    }
}
