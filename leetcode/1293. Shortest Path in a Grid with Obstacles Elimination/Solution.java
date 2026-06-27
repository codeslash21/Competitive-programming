// https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/description/
// using BFS
// t.c.=O(mnk), s.c.=O(mnk)
class Solution {
    public int shortestPath(int[][] grid, int k) {
        int rows=grid.length, cols=grid[0].length;
        if(k>=rows+cols-3)  return rows+cols-2;
        Queue<int[]> queue=new LinkedList<>();
        boolean[][][] visited=new boolean[rows][cols][k+1];
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        // queue stores an array of {row, col, remaining eliminations, steps}
        queue.offer(new int[]{0, 0, k, 0});
        visited[0][0][k]=true;
        while(!queue.isEmpty()) {
            int[] state=queue.poll();
            int row=state[0], col=state[1], remK=state[2], steps=state[3];
            if(row==rows-1 && col==cols-1)
                return steps;
            for(int[] dir:directions) {
                int newRow=row+dir[0], newCol=col+dir[1];
                if(newRow<0 || newRow>=rows || newCol<0 || newCol>=cols)    continue;
                int newK=remK-grid[newRow][newCol];
                if(newK>=0 && !visited[newRow][newCol][newK]) {
                    queue.offer(new int[]{newRow, newCol, newK, steps+1});
                    visited[newRow][newCol][newK]=true;
                }
            }
        }
        return -1;
    }
}

// using A* algorithm
// t.c.=O(mnk * log(mnk)), s.c.=O(mnk)
class Solution {
    public int shortestPath(int[][] grid, int k) {
        int rows=grid.length, cols=grid[0].length;
        if(k>=rows+cols-3)  return rows+cols-2;
        boolean[][][] visited=new boolean[rows][cols][k+1];
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        // Min-heap ordered by f = steps + manhattan distance to goal
        // Store {f-value, row, col, remaining eliminations, steps}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{rows+cols-2, 0, 0, k, 0});
        visited[0][0][k]=true;
        while(!pq.isEmpty()) {
            int[] state=pq.poll();
            int row=state[1], col=state[2], remK=state[3], steps=state[4];
            if(row==rows-1 && col==cols-1)
                return steps;
            for(int[] dir:directions) {
                int newRow=row+dir[0], newCol=col+dir[1];
                if(newRow<0 || newRow>=rows || newCol<0 || newCol>=cols)    continue;
                int newK=remK-grid[newRow][newCol];
                if(newK>=0 && !visited[newRow][newCol][newK]) {
                    int newSteps=steps+1+rows+cols-2-newRow-newCol;
                    pq.offer(new int[]{newSteps, newRow, newCol, newK, steps+1});
                    visited[newRow][newCol][newK]=true;
                }
            }
        }
        return -1;
    }
}
