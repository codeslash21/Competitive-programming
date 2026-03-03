// https://leetcode.com/problems/range-sum-query-2d-immutable/description/
// using cumulative sum
// t.c.=O(m), during initialization O(m*n), s.c.=O(m*n)
class NumMatrix {
    private int[][] dp;
    public NumMatrix(int[][] matrix) {
        int rows=matrix.length, cols=matrix[0].length;
        dp=new int[rows][cols+1];
        for(int row=0;row<rows;row++)
            for(int col=0;col<cols;col++)
                dp[row][col+1]=dp[row][col]+matrix[row][col];
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum=0;
        for(int row=row1;row<=row2;row++)
            sum+=dp[row][col2+1]-dp[row][col1];
        return sum;
    }
}

// using 2D cumulative sum
// t.c.=O(1), O(mn) during pre-computation, s.c.=O(mn)
class NumMatrix {
    int[][] dp;
    public NumMatrix(int[][] matrix) {
        int rows=matrix.length, cols=matrix[0].length;
        dp=new int[rows+1][cols+1];
        for(int row=0;row<rows;row++)
            for(int col=0;col<cols;col++)
                dp[row+1][col+1]=dp[row+1][col]+dp[row][col+1]+matrix[row][col]-dp[row][col];
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2+1][col2+1]-dp[row1][col2+1]-dp[row2+1][col1]+dp[row1][col1];
    }
}
