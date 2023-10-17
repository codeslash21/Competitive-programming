// Using BFS
// t.c.=O(m*n), s.c.=O(m*n)
class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        int[][] dirs = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
        int row=grid1.length, col=grid1[0].length, res=0;
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++) 
                if(grid2[i][j]==1) {
                    queue.offer(new Pair(i, j));
                    grid2[i][j]=0;
                    boolean flag=true;
                    while(!queue.isEmpty()) {
                        Pair curr = queue.remove();
                        int r=(int)curr.getKey(), c=(int)curr.getValue();
                        if(grid1[r][c]!=1)
                            flag=false;
                        for(int[] d:dirs) {
                            int newR = r+d[0], newC=c+d[1];
                            if(newR>=0&&newR<row && newC>=0 && newC<col&&grid2[newR][newC]==1) {
                                grid2[newR][newC]=0;
                                queue.offer(new Pair(newR, newC));
                            }                             
                        }
                    }
                    if(flag)
                        res++;
                }
        return res;
    }
}
