// https://leetcode.com/problems/max-points-on-a-line/description/
// using bruteforce, check every triplet
// t.c.=O(n^3), s.c.=O(1)
class Solution {
    public int maxPoints(int[][] points) {
        int len=points.length;
        if(len<3) return len;
        int maxCount=2;
        for(int i=0;i<len;i++) {
            for(int j=i+1;j<len;j++) {
                int count=2;
                for(int k=0;k<len;k++) {
                    if(k==i || k==j)    continue;
                    int collinearValue=(points[j][1]-points[i][1])*(points[k][0]-points[i][0])-
                                       (points[k][1]-points[i][1])*(points[j][0]-points[i][0]);
                    if(collinearValue==0)
                        count++;
                }
                maxCount=Math.max(maxCount, count);
            }
        }
        return maxCount;
    }
}

// using slope
// t.c.=O(n^2), s.c.=O(n)
class Solution {
    public int maxPoints(int[][] points) {
        int len=points.length;
        if(len<3)   return len;
        int result=2;
        for(int i=0;i<len;i++) {
            Map<Double, Integer> count=new HashMap<>();
            for(int j=0;j<len;j++) {
                if(i==j)    continue;
                Double angle=Math.atan2(points[j][1]-points[i][1], points[j][0]-points[i][0]);
                count.put(angle, count.getOrDefault(angle, 0)+1);
            }
            result=Math.max(result, Collections.max(count.values())+1);
        }
        return result;
    }
}
