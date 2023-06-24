// Using bfs
// t.c.=O(m*n), s.c.=O(m*n)
class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length, n=grid[0].length, res=0, cnt=0;
        Queue<List<Integer>> queue = new LinkedList<>();
        int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(grid[i][j]==2)
                    queue.add(new ArrayList<Integer>(Arrays.asList(i, j)));
                else if(grid[i][j]==1)
                    cnt++;
        while(!queue.isEmpty()) {
            int len=queue.size();
            for(int k=0;k<len;k++) {
                List<Integer> pair = queue.remove();
                int i=pair.get(0), j=pair.get(1);
                for(int[] d:direction) {
                    int row=i+d[0], col=j+d[1];
                    if(row>=0 && row<m && col>=0 && col<n)
                        if(grid[row][col]==1) {
                            cnt--;
                            grid[row][col]=2;
                            queue.add(new ArrayList<Integer>(Arrays.asList(row, col)));
                        }
                }
            }
            if(queue.size()>0)
                res++;
        }
        return cnt==0?res:-1;
    }
}
