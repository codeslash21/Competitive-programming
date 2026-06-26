// https://leetcode.com/problems/making-a-large-island/description/
// using dfs
// t.c.=O(n^2), s.c.=O(n^2)
class Solution {
    private int[][] directions=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int largestIsland(int[][] grid) {
        int n=grid.length, maxArea=0, islandId=2;
        boolean hasZero=false;
        Map<Integer, Integer> islandSizes=new HashMap<>();
        for(int r=0;r<n;r++)
            for(int c=0;c<n;c++) 
                if(grid[r][c]==1) {
                    int islandSize=dfs(grid, r, c, islandId);
                    islandSizes.put(islandId++, islandSize);
                }
        for(int r=0;r<n;r++)
            for(int c=0;c<n;c++) 
                if(grid[r][c]==0) {
                    int islandSize=1;
                    hasZero=true;
                    Set<Integer> neighborIslands=new HashSet<>();
                    for(int[] dir:directions) {
                        int newRow=r+dir[0], newCol=c+dir[1];
                        if(newRow>=0 && newRow<n && newCol>=0 && newCol<n && 
                            grid[newRow][newCol]>1)
                            neighborIslands.add(grid[newRow][newCol]);
                    }
                    for(int island:neighborIslands)
                        islandSize+=islandSizes.getOrDefault(island, 0);
                    maxArea=Math.max(maxArea, islandSize);
                }
        return hasZero?maxArea:n*n;
    }
    private int dfs(int[][] grid, int row, int col, int islandId) {
        int n=grid.length;
        if(row<0 || row>=n || col<0 || col>=n || grid[row][col]!=1)
            return 0;
        int size=1;
        grid[row][col]=islandId;
        for(int[] dir:directions) 
            size+=dfs(grid, row+dir[0], col+dir[1], islandId);
        return size;
    }
}
