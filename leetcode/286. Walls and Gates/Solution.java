// using bfs
// t.c.=O(m*n), s.c.=O(m*n)
class Solution {
    public void wallsAndGates(int[][] rooms) {
        Queue<List<Integer>> queue = new LinkedList<>();
        int[][] direction = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int m=rooms.length, n=rooms[0].length, inf=Integer.MAX_VALUE;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(rooms[i][j]==0)
                    queue.add(new ArrayList<Integer>(Arrays.asList(i, j)));
        while(!queue.isEmpty()) {
            List<Integer> pair = queue.remove();
            int i=pair.get(0), j=pair.get(1);
            for(int[] d:direction) {
                int row=i+d[0], col=j+d[1];
                if(row>=0 && row<m && col>=0 && col<n && rooms[row][col]==inf){
                    rooms[row][col]=rooms[i][j]+1;
                    queue.add(Arrays.asList(row, col));
                }
            }
        }
    }
}
