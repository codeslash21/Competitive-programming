class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int or=mat.length, oc=mat[0].length;
        if(or*oc!=r*c)
            return mat;
        int[][] reshaped = new int[r][c];
        for(int i=0;i<or;i++)
            for(int j=0;j<oc;j++){
                int num=i*oc+j;
                reshaped[num/c][num%c]=mat[i][j];
            }
        return reshaped;
    }
}
