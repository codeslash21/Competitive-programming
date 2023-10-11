// Using dfs
// t.c.=O(V+E), s.c.=O(V+E)
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length, res=0;
        boolean[] seen = new boolean[n];
        for(int i=0;i<n;i++) 
            if(!seen[i]){
                seen[i]=true;
                dfs(isConnected, seen, i, n);
                res++;
            }
        return res;
    }
    private void dfs(int[][] isConnected, boolean[] seen, int curr, int n) {
        for(int i=0;i<n;i++) 
            if(isConnected[curr][i]==1 && !seen[i]) {
                seen[i]=true;
                dfs(isConnected, seen, i, n);
            }
    }
}
