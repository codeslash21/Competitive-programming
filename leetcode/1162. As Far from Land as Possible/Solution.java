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

// Using dp
// t.c.=O(n^2), s.c.=O(n^2)
class Solution {
    public int maxDistance(int[][] grid) {
        int n=grid.length;
        int max_dist = n+n+1;
        int[][] dist = new int[n][n];
        for(int[] arr:dist)
            Arrays.fill(arr, max_dist);
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++) 
                if(grid[i][j]==1)
                    dist[i][j]=0;
                else 
                    dist[i][j]=Math.min(dist[i][j], Math.min(i>0?dist[i-1][j]+1:max_dist, j>0?dist[i][j-1]+1:max_dist));
        int ans=0;
        for(int i=n-1;i>=0;i--)
            for(int j=n-1;j>=0;j--){
                dist[i][j]=Math.min(dist[i][j], Math.min(i<n-1?dist[i+1][j]+1:max_dist, j<n-1?dist[i][j+1]+1:max_dist));
                ans=Math.max(ans, dist[i][j]);
            }
        return ans==0||ans==max_dist?-1:ans;
    }
}
