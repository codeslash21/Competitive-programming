// using bfs
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int srColor=image[sr][sc], m=image.length, n=image[0].length;
        if(srColor==color)
            return image;
        int[][] directions = new int[][] {{-1,0},{1,0},{0,1},{0,-1}};
        Queue<Integer[]> queue = new LinkedList<>();
        image[sr][sc]=color;
        queue.offer(new Integer[]{sr,sc});
        while(!queue.isEmpty()) {
            Integer[] arr = queue.remove();
            for(int[] d:directions) {
                int row=arr[0]+d[0], col=arr[1]+d[1];
                if(row>=0 && row<m && col>=0 && col<n)
                    if(image[row][col]==srColor) {
                        image[row][col]=color;
                        queue.offer(new Integer[]{row, col});
                    }
            }
        }
        return image;
    }
}
