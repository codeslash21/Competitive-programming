// Using set ans hashing
// t.c.=O(m*n), s.c.=O(m*n)
class Solution {
    public int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<>();
        int[][] d = new int[][] {{0,-1}, {0,1}, {-1,0}, {1,0}};
        char[] dSymb = new char[] {'L', 'R', 'U', 'D'};
        Queue<int[]> queue = new LinkedList<>();
        int m=grid.length, n=grid[0].length;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++) 
                if(grid[i][j]==1) {
                    // System.out.println(i+ " "+j);
                    sb.append('R').append('#');
                    queue.add(new int[] {i,j});
                    while(!queue.isEmpty()) {
                        int len=queue.size();
                        for(int k=0;k<len;k++) {
                            int[] pair = queue.remove();
                            for(int l=0;l<d.length;l++) {
                                int row=pair[0]+d[l][0], col=pair[1]+d[l][1];
                                if(row<m && row>=0 && col<n && col>=0 && grid[row][col]==1) {
                                    grid[row][col]=0;
                                    queue.add(new int[] {row, col});
                                    sb.append(dSymb[l]);
                                }
                            }
                            sb.append('#');
                        }
                    }
                    set.add(sb.toString());
                    sb.delete(0, sb.length());
                }
        return set.size();
    }
}
