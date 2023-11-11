// Using dfs and bfs
// t.c.=O(n^2), s.c.=O(n^2)
class Solution {
    int n;
    int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    Queue<int[]> queue = new LinkedList<>();
    private void dfs(int[][] grid, int r, int c) {
        grid[r][c]=2;
        queue.offer(new int[] {r, c});
        for(int[] d:dirs) {
            int nr=r+d[0], nc=c+d[1];
            if(nr>=0 && nr<n && nc>=0 && nc<n && grid[nr][nc]==1)
                dfs(grid, nr, nc);
        }
    }
    public int shortestBridge(int[][] grid) {
        n=grid.length;
        int res=0;
        boolean flag=false;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                if(grid[i][j]==1){
                    dfs(grid, i, j);
                    flag=true;
                    break;
                }
            if(flag)
                break;
        }
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i=0;i<len;i++) {
                int[] curr = queue.poll();
                for(int[] d:dirs) {
                    int nr=curr[0]+d[0], nc=curr[1]+d[1];
                    if(nr>=0 && nr<n && nc>=0 && nc<n)
                        if(grid[nr][nc]==0) {
                            grid[nr][nc]=-1;
                            queue.offer(new int[]{nr, nc});
                        }
                        else if(grid[nr][nc]==1)
                            return res;
                }
            }
            res++;
        }
        return 0;
    }
}
