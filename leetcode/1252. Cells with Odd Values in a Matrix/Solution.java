// t.c. = O(m*n), s.c.=O(m+n)
class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int cnt=0;
        int[] row = new int[m], col = new int[n];
        for(int x[]:indices) {
            row[x[0]]++;
            col[x[1]]++;
        }
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if((row[i]+col[j])%2!=0)
                    cnt++;
        return cnt;
    }
}
