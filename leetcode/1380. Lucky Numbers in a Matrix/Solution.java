// t.c.=O(m*n), s.c.=O(1)
class Solution {
    public List<Integer> luckyNumbers (int[][] mat) {
        int r=mat.length, c=mat[0].length;
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<r;i++) {
            int min=mat[i][0], idx=0;
            boolean flag=true;
            for(int j=0;j<c;j++)
                if(mat[i][j]<min) {
                    min=mat[i][j];
                    idx=j;
                }
            int max=mat[i][idx];
            for(int k=0;k<r;k++)
                if(mat[k][idx]>max) {
                    flag=false;
                    break;
                }
            if(flag)
                res.add(max);
        }
        return res;
    }
}
