class Solution {
    public int diagonalSum(int[][] mat) {
        int n=mat.length;
        int sum=0, j=0, k=n-1;
        for(int i=0;i<n;i++) {
            sum+=mat[i][j++]+mat[i][k--];
        }
        if(n%2==1)
            sum-=mat[n/2][n/2];
        return sum;
    }
}
