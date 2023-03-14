// Using greedy algorithm
// t.c.=O(n), s.c.=O(1)
class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        int len=s.length();
        for(int i=0;i<len;i++)
            last[s.charAt(i)-'a']=i;
        List<Integer> ans = new ArrayList<>();
        int anchor=0,j=0;
        for(int i=0;i<len;i++) {
            j=Math.max(j, last[s.charAt(i)-'a']);
            if(i==j) {
                ans.add(i-anchor+1);
                anchor=i+1;
            }
        }
        return ans;
    }
}
