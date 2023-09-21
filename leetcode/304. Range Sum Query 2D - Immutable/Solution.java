class NumMatrix {
    private int[] prefix;
    private int m, n;
    public NumMatrix(int[][] matrix) {
        m=matrix.length;
        n=matrix[0].length;
        int idx=1;
        prefix = new int[m*n+1];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                prefix[idx]=prefix[idx-1]+matrix[i][j];
                idx++;
            }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int row=row2-row1+1, col=col2-col1+1;
        int left=row1*n+col1, sum=0;
        for(int i=0;i<row;i++) {
            sum+=(prefix[left+col]-prefix[left]);
            left+=n;
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
