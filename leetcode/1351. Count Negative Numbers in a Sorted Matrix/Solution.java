// Using binary search
// t.c.=O(mlogn), s.c.=O(1)
class Solution {
    public int binSearch(int[] grid, int start, int end) {
        int right = end+1;
        int index=right;
        while(start<=end) {
            int mid=(start+end)/2;
            if(grid[mid]>=0)
                start=mid+1;
            else {
                index=mid;
                end=mid-1;
            }
        }
        if(index==right)
            return 0;
        return right-index;
    }
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int cnt=0;
        for(int i=0;i<m;i++) {
            cnt+= binSearch(grid[i], 0, n-1);
        }
        return cnt;
    }
}

// Optimized method
// t.c.=O(m+n), s.c.=O(1)
class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int cnt=0;
        int i=m-1, j=0;
        while(i>=0 && j<n)
            if(grid[i][j]<0) {
                cnt+=(n-j);
                i--;
            }
            else
                j++;
        return cnt;
    }
}
