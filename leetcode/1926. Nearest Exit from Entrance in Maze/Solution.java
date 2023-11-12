// Using bfs
// t.c.=O(m*n), s.c.=O(m+n)
class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> queue = new LinkedList<>();
        int m=maze.length, n=maze[0].length, res=0;
        int[][] dirs = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        queue.offer(entrance);
        while(!queue.isEmpty()) {
            int len=queue.size();
            while(len-->0) {
                int[] curr = queue.poll();
                int r=curr[0], c=curr[1];
                if(r==0 || r==m-1 || c==0 || c==n-1)
                    if(r!=entrance[0] || c!=entrance[1])
                        return res;
                for(int[] dir:dirs) {
                    int nr=r+dir[0], nc=c+dir[1];
                    if(nr>=0 && nr<m && nc>=0 && nc<n && maze[nr][nc]=='.'){
                        queue.offer(new int[]{nr, nc});
                        maze[nr][nc]='+';
                    }
                }
            }
            res++;
        }
        return -1;
    }
}
