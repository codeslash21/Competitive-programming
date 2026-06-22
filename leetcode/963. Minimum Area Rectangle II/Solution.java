// https://leetcode.com/problems/minimum-area-rectangle-ii/
// using diagonal grouping
// t.c.=O(n^2 + R), s.c.=O(n^2), R=total number of rectangle candidates
class Solution {
    public double minAreaFreeRect(int[][] points) {
        int n=points.length;
        double minArea=Double.MAX_VALUE;
        Map<String, List<int[]>> groups=new HashMap<>();
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                int mx=points[i][0]+points[j][0], my=points[i][1]+points[j][1];
                int dx=points[i][0]-points[j][0], dy=points[i][1]-points[j][1];
                long distSq=(long)dx*dx + (long)dy*dy;
                String key=String.valueOf(mx)+"#"+String.valueOf(my)+"#"+String.valueOf(distSq);
                groups.computeIfAbsent(key, k->new ArrayList<>()).add(new int[]{i,j});
            }
        }
        for(List<int[]> pairs:groups.values()) {
            for(int i=0;i<pairs.size();i++) {
                for(int j=i+1;j<pairs.size();j++) {
                    int firstPointIdx=pairs.get(i)[0], secondPointIdx=pairs.get(i)[1];
                    int cornerPointIdx=pairs.get(j)[0];
                    int side1x=points[firstPointIdx][0]-points[secondPointIdx][0];
                    int side1y=points[firstPointIdx][1]-points[secondPointIdx][1];
                    int side2x=points[cornerPointIdx][0]-points[secondPointIdx][0];
                    int side2y=points[cornerPointIdx][1]-points[secondPointIdx][1];
                    double area=Math.abs((double)side1x*side2y-(double)side1y*side2x);
                    minArea=Math.min(minArea, area);
                }
            }
        }
        return minArea==Double.MAX_VALUE?0.0:minArea;
    }
}
