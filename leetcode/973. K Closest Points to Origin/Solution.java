// Using sorting
// t.c.=O(nlogn), s.c.=O(n)
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n=points.length;
        int[][] arr = new int[n][3];
        for(int i=0;i<n;i++){
            int x=points[i][0];
            int y=points[i][1];
            arr[i]=new int[]{x, y, (int)Math.pow(x,2)+(int)Math.pow(y,2)};
        }
        Arrays.sort(arr, (a,b)->a[2]-b[2]);
        int[][] ans = new int[k][2];
        for(int i=0;i<k;i++)
            ans[i]=new int[]{arr[i][0], arr[i][1]};
        return ans;
    }
}
