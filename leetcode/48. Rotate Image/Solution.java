// Rotating group of four elements
// t.c.=O(m), s.c.=O(1) where m is the number of elements in the matrix
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix[0].length;
        for(int i=0;i<n/2;i++) {
            for(int j=i;j<n-1-i;j++) {
                int temp = matrix[n-1-j][i];
                matrix[n-1-j][i]=matrix[n-i-1][n-1-j];
                matrix[n-i-1][n-1-j]=matrix[j][n-1-i];
                matrix[j][n-1-i]=matrix[i][j];
                matrix[i][j]=temp;
            }
        }
    }
}

// Using transpose+reverse(left to right)
// t.c.=O(m), s.c.=O(1)
class Solution {
    public void transpose(int[][] arr, int n) {
        for(int i=0;i<n;i++)
            for(int j=i+1;j<n;j++) {
                int temp=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
    }
    public void reverse(int[][] arr, int n) {
        for(int i=0;i<n;i++) 
            for(int j=0;j<n/2;j++) {
                int temp=arr[i][j];
                arr[i][j]=arr[i][n-1-j];
                arr[i][n-1-j]=temp;
            }
    }
    public void rotate(int[][] matrix) {
        int n = matrix[0].length;
        transpose(matrix, n);
        reverse(matrix, n);
    }
}
