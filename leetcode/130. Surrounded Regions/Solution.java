// Using bfs
// s.c.=O(m+n), s.c.=O(m+n), where m= number of rows and n=number of cols
class Pair<U, V> {
    public U first;
    public V second;
    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public void solve(char[][] board) {
        int row=board.length, col=board[0].length;
        List<Pair<Integer, Integer>> border = new ArrayList<>();
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        int[][] direction = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        for(int i=0;i<row;i++) {
            border.add(new Pair(i, 0));
            border.add(new Pair(i, col-1));
        }
        for(int i=0;i<col;i++) {
            border.add(new Pair(0, i));
            border.add(new Pair(row-1, i));
        }
        for(Pair<Integer, Integer> p:border)
            if(board[p.first][p.second]=='O') {
                board[p.first][p.second]='E';
                queue.offer(p);
            }
        while(!queue.isEmpty()) {
            Pair<Integer, Integer> p = queue.poll();
            for(int[] d:direction) {
                int r=p.first+d[0], c=p.second+d[1];
                if(r>=0 && r<row && c>=0 && c<col && board[r][c]=='O') {
                    board[r][c]='E';
                    queue.offer(new Pair(r,c));
                }
            }
        }
        for(int r=0;r<row;r++)
            for(int c=0;c<col;c++)
                if(board[r][c]=='O')
                    board[r][c]='X';
                else if(board[r][c]=='E')
                    board[r][c]='O';
    }
}
