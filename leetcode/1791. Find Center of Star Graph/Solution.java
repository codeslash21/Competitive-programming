// using one array
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int findCenter(int[][] edges) {
        int n=edges.length;
        int[] freq = new int[n+2];
        for(int[] edge:edges) {
            freq[edge[0]]++;
            freq[edge[1]]++;
        }
        for(int i=0;i<n+2;i++)
            if(freq[i]==n)
                return i;
        return 0;
    }
}
