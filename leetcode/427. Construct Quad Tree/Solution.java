// https://leetcode.com/problems/construct-quad-tree/description/
// using recursive bruteforce
// t.c.=O(n^2 * logn), s.c.=O(logn)
class Solution {
    public Node construct(int[][] grid) {
        return build(grid, 0, 0, grid.length);
    }
    private Node build(int[][] grid, int row, int col, int size) {
        boolean uniform=true;
        int val=grid[row][col];
        for(int i=row;i<row+size && uniform;i++)
            for(int j=col;j<col+size && uniform;j++)
                if(grid[i][j]!=val)
                    uniform=false;
        // if uniform, return a leaf node
        if(uniform)
            return new Node(val==1, true);
        // otherwise divide the grid into four quadrants
        int half=size/2;
        Node topLeft=build(grid, row, col, half);
        Node topRight=build(grid, row, col+half, half);
        Node bottomLeft=build(grid, row+half, col, half);
        Node bottomRight=build(grid, row+half, col+half, half);
        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}

// using prefix sum
// t.c.=O(n^2), s.c.=O(n^2)
class Solution {
    private int[][] prefix;
    public Node construct(int[][] grid) {
        int len=grid.length;
        prefix=new int[len+1][len+1];
        for(int i=1;i<=len;i++)
            for(int j=1;j<=len;j++)
                prefix[i][j]=grid[i-1][j-1]+prefix[i-1][j]+prefix[i][j-1]-prefix[i-1][j-1];
        return build(grid, 0, 0, len);
    }
    private int getRegionSum(int row, int col, int size) {
        return prefix[row+size][col+size]-prefix[row][col+size]-prefix[row+size][col]+prefix[row][col];
    }
    private Node build(int[][] grid, int row, int col, int size) {
        int sum=getRegionSum(row, col, size);
        // If all zeros or all 1's then leaf node
        if(sum==0)  return new Node(false, true);
        if(sum==(size*size))   return new Node(true, true);
        // otherwise subdivide into four quadrants
        int half=size/2;
        Node topLeft=build(grid, row, col, half);
        Node topRight=build(grid, row, col+half, half);
        Node bottomLeft=build(grid, row+half, col, half);
        Node bottomRight=build(grid, row+half, col+half, half);
        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}
