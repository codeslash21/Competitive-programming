// Using backtracking
// t.c.=O(3^N), s.c.=O(L*X) where N=total number of cells, L=ax length of path, X=total number of path
class Solution {
    ArrayList<String> res;
    int[][] direcV = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    char[] direcL = new char[] {'U', 'D', 'L', 'R'};
    public ArrayList<String> findPath(int[][] m, int n) {
        res = new ArrayList<>();
        if(m[0][0]!=0 && m[n-1][n-1]!=0)
            backtrack(m, 0, 0, n, new StringBuilder());
        if(res.size()==0)
            res.add("-1");
        return res;
    }
    public void backtrack(int[][] m, int r, int c, int n, StringBuilder sb) {
        if(r==n-1 && c==n-1) {
            res.add(sb.toString());
            return;
        }
        int temp=m[r][c];
        m[r][c]=-1;
        for(int i=0;i<4;i++) {
            int row=r+direcV[i][0], col=c+direcV[i][1];
            if(row<0 || row>=n || col<0 || col>=n || m[row][col]<=0)
                continue;
            sb.append(direcL[i]);
            backtrack(m, row, col, n, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        m[r][c]=temp;
    }
}
