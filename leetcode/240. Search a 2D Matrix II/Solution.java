// usign linear algo, search space reduction
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

// Using devide and conquer
// t.c.=O(nlogn), s.c.=O(logn)
class Solution {
    private int[][] arr;
    private int target;
    private boolean searchRec(int left, int up, int right, int down) {
        if(left>right || up>down)
            return false;
        else if(target<arr[up][left] || target>arr[down][right])
            return false;
        int mid=(left+right)/2;
        int row=up;
        while(row<=down && arr[row][mid]<=target) {
            if(arr[row][mid]==target)
                return true;
            row++;
        }
        return searchRec(left, row, mid-1, down) || searchRec(mid+1, up, right, row-1);
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        this.arr = matrix;
        this.target = target;
        return searchRec(0, 0, arr[0].length-1, arr.length-1);
    }
}
