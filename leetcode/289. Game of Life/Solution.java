// Using extra space
// t.c.=O(mn), s.c.=O(mn)
class Solution {
    public void gameOfLife(int[][] board) {
        int m=board.length;
        int n=board[0].length;
        int[][] newBoard = Arrays.stream(board).map(int[]::clone).toArray(int[][]::new);
        int[][] index=new int[][]{{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1}};
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                int cnt=0;
                for(int[] ind:index) {
                    int row=i+ind[0];
                    int col=j+ind[1];
                    if(row<m && row>=0 && col<n && col>=0 && newBoard[row][col]==1)
                        cnt++;
                }
                if(newBoard[i][j]==1 && (cnt<2 || cnt>3))
                    board[i][j]=0;
                else if(newBoard[i][j]==0 && cnt==3)
                    board[i][j]=1;
            }
        }
    }
}

// Without using extra space
// t.c.=O(mn), s.c.=O(1)
class Solution {
    public void gameOfLife(int[][] board) {
        int m=board.length;
        int n=board[0].length;
        int[][] index=new int[][]{{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1}};
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                int cnt=0;
                for(int[] ind:index) {
                    int row=i+ind[0];
                    int col=j+ind[1];
                    if(row<m && row>=0 && col<n && col>=0 && (board[row][col]==1 || board[row][col]==-1))
                        cnt++;
                }
                if(board[i][j]==1 && (cnt<2 || cnt>3))
                    board[i][j]=-1;
                else if(board[i][j]==0 && cnt==3)
                    board[i][j]=2;
            }
        }
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(board[i][j]==-1)
                    board[i][j]=0;
                else if(board[i][j]==2)
                    board[i][j]=1;
    }
}
