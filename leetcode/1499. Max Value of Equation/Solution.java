// https://leetcode.com/problems/max-value-of-equation/description/
// using deque
// t.c.=O(n), s.c.=O(min(n,k))
class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int len=points.length, res=Integer.MIN_VALUE;
        Deque<int[]> queue=new ArrayDeque<int[]>();
        queue.offer(new int[]{points[0][0], 0});
        for(int i=1;i<len;i++) {
            int currX=points[i][0], currXY=points[i][1]+points[i][0], diffXY=points[i][1]-points[i][0];
            // remove points beyond window
            while(!queue.isEmpty() && queue.peekFirst()[0]<(currX-k))
                queue.pollFirst();
            // calculate value if point exists within the window
            if(!queue.isEmpty()) {
                int[] point=points[queue.peekFirst()[1]];
                int val=point[1]+currXY-point[0];
                res=Math.max(res, val);
            }
            while(!queue.isEmpty() && (points[queue.peekLast()[1]][1]-points[queue.peekLast()[1]][0])<=diffXY)
                queue.pollLast();
            queue.offerLast(new int[]{currX, i});
        }
        return res;
    }
}
