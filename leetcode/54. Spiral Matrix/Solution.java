// t.c.=O(m*n), s.c.=O(1)
class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        List<Integer> res = new ArrayList<>();
        int rows = mat.length, cols = mat[0].length;
        int up=0, down=rows-1, left=0, right=cols-1;
        while(res.size()<rows*cols) {
            for(int col=left;col<=right;col++)
                res.add(mat[up][col]);
            for(int row=up+1; row<=down;row++)
                res.add(mat[row][right]);
            if(up!=down) {
                for(int col=right-1;col>=left;col--)
                    res.add(mat[down][col]);
            }
            if(left!=right)
                for(int row=down-1;row>up;row--)
                    res.add(mat[row][left]);
            left++;
            right--;
            up++;
            down--;
        }
        return res;
    }
}
