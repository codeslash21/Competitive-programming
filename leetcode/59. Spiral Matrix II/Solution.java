// t.c.=O(n*n), s.c.=O(1)
class Solution {
    public int[][] generateMatrix(int n) {
        int up=0, down=n-1, left=0, right=n-1, k=1;
        int[][] res = new int[n][n];
        while(k<=n*n) {
            for(int i=left;i<=right;i++)
                res[up][i]=k++;
            for(int i=up+1;i<=down;i++)
                res[i][right]=k++;
            if(up!=down)
                for(int i=right-1;i>=left;i--)
                    res[down][i]=k++;
            if(left!=right)
                for(int i=down-1;i>up;i--)
                    res[i][left]=k++;
            up++;
            down--;
            left++;
            right--;
        }
        return res;
    }
}
