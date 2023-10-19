// using bfs
// t.c.=O(n), s.c.=O(n)
class Solution {
    int[][] dirs = new int[][] {{0,1},{1,0},{0,-1},{-1,0},{1,1},{-1,-1},{1,-1},{-1,1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length, level=0;
        if(grid[0][0]==1 || grid[n-1][n-1]==1)
            return -1;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair(0, 0));
        while(!queue.isEmpty()) {
            level++;
            int len=queue.size();
            for(int i=0;i<len;i++) {
                Pair curr = queue.remove();
                int r=(int)curr.getKey(), c=(int)curr.getValue();
                if(r==n-1 && c==n-1)
                    return level;
                for(int[] dir:dirs) {
                    int newR=r+dir[0], newC=c+dir[1];
                    if(newR>=0&&newR<n&&newC>=0&&newC<n&&grid[newR][newC]==0){
                        queue.offer(new Pair(newR, newC));
                        grid[newR][newC]=2;
                    }
                }
            }           
        }
        return -1;
    }
}
