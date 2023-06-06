// Using prefix sum
// t.c.=O(n), s.c.=O(n)
class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int n=s.length();
        List<Boolean> res = new ArrayList<>();
        int[][] pre = new int[n][26];
        int[] temp = new int[26];
        for(int i=0; i<n; i++) {
            temp[s.charAt(i)-'a']++;
            for(int j=0; j<26; j++)
                pre[i][j]=temp[j];
        }
        for(int[] q:queries) {
            int l=q[0], r=q[1], k=q[2], cnt=0;
            for(int i=0; i<26; i++)
                if(l-1>=0)
                    cnt+=(pre[r][i]-pre[l-1][i])%2;
                else
                    cnt+=pre[r][i]%2;
            res.add(cnt/2<=k);
        }
        return res;
    }
}
