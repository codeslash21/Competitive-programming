// using bfs
// t.c.=O(n^2), s.c.=O(n^2)
class Solution {
    public int maxDistance(int[][] grid) {
        int n=grid.length, distance=-1;
        int[][] visited = new int[n][n];
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        int[][] dirs = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++) {
                visited[i][j]=grid[i][j];
                if(grid[i][j]==1)
                    queue.offer(new Pair(i,j));
            }
        while(!queue.isEmpty()) {
            int qSize = queue.size();
            while(qSize-->0) {
                Pair<Integer, Integer> landCell = queue.poll();
                for(int[] dir:dirs) {
                    int x=landCell.getKey()+dir[0];
                    int y=landCell.getValue()+dir[1];
                    if(x>=0 && x<n && y>=0 && y<n && visited[x][y]==0) {
                        visited[x][y]=1;
                        queue.offer(new Pair(x,y));
                    }
                }
            }
            distance++;
        }
        return distance<=0?-1:distance;
    }
}
