// using greedy method
// t.c.=O(nlogn), s.c.=O(logn) for sorting
class Solution {
    public int findMinArrowShots(int[][] points) {
        int n=points.length;
        Arrays.sort(points, (a,b)->{
            if(a[1]==b[1])  return 0;
            if(a[1]<b[1])   return -1;
            return 1;
        });
        int arrow=1, xstart, xend, firstend=points[0][1];
        for(int[] point:points) {
            xstart=point[0];
            xend=point[1];
            if(xstart>firstend) {
                arrow++;
                firstend=xend;
            }   
        }
        return arrow;
    }
}
