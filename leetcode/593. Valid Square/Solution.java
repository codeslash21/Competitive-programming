// https://leetcode.com/problems/valid-square/description/
// t.c.=O(1), s.c.=O(1)
class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        long[] dists=new long[]{dist(p1, p2), dist(p1, p3), dist(p1, p4), dist(p2, p3), dist(p2, p4), dist(p3, p4)};
        Map<Long, Integer> distFreq=new HashMap<>();
        for(long d:dists)
            distFreq.put(d, distFreq.getOrDefault(d, 0)+1);
        if(distFreq.size()!=2)  return false;
        long side=Long.MAX_VALUE, diag=Long.MIN_VALUE;
        for(long d:distFreq.keySet()) {
            side=Math.min(side, d);
            diag=Math.max(diag, d);
        }
        return distFreq.get(side)==4 && diag==2*side;
    }
    private long dist(int[] p1, int[] p2) {
        return (long)(p1[0]-p2[0])*(p1[0]-p2[0])+(long)(p1[1]-p2[1])*(p1[1]-p2[1]);
    }
}
