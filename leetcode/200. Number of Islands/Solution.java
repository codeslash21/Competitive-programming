// using bfs
// t.c.=O(m*n), s.c.=O(max(m,n))
class Solution {
    public int numIslands(char[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int m=grid.length, n=grid[0].length, res=0;
        int[][] direction = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(grid[i][j]=='1'){
                    queue.add(new int[] {i,j});
                    res++;
                    while(!queue.isEmpty()) {
                        int[] pair = queue.remove();
                        int k=pair[0], l=pair[1];
                        for(int[] d:direction) {
                            int row=k+d[0], col=l+d[1];
                            if(row<m && row>=0 && col<n && col>=0 && grid[row][col]=='1') {
                                grid[row][col]='0';
                                queue.add(new int[]{row, col});
                            }
                        }
                    }
                }
        return res;
    }
}
