// using one array
// t.c.=O(N), s.c.=O(n)
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] freq = new int[n+1];
        for(int[] t:trust){
            freq[t[1]]++;
            freq[t[0]]--;
        }
        for(int i=1;i<=n;i++)
            if(freq[i]==n-1)
                return i;
        return -1;
    }
}
