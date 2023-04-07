// Using linear time algo
// t.c.=O(m+n), s.c.=O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length, n=matrix[0].length;
        int row=m-1, col=0;
        while(row>=0 && col<n) {
            if(matrix[row][col]==target)
                return true;
            else if(matrix[row][col]>target)
                row--;
            else
                col++;
        }
        return false;
    }
}

// Using binary search
// t.c.=O(log(m*n)), s.c.=O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length, n=matrix[0].length;
        int left=0, right=m*n-1;
        int pivotIdx, pivotEle;
        while(left<=right) {
            pivotIdx=(left+right)/2;
            pivotEle=matrix[pivotIdx/n][pivotIdx%n];
            if(pivotEle==target)
                return true;
            else if(pivotEle>target)
                right=pivotIdx-1;
            else
                left=pivotIdx+1;
        }
        return false;
    }
}
