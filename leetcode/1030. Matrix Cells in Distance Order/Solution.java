// t.c.=O(m*n), s.c.O(m*n)

class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int max=0;
        Map<Integer, List<int[]>> map = new HashMap<>();
        int[][] res = new int[rows*cols][2];
        for(int i=0;i<rows;i++)
            for(int j=0;j<cols;j++) {
                int dist=Math.abs(i-rCenter)+Math.abs(j-cCenter);
                if(!map.containsKey(dist))
                    map.put(dist, new ArrayList<>());
                map.get(dist).add(new int[]{i,j});
                if(dist>max)
                    max=dist;
            }
        int k=0;
        for(int i=0;i<=max;i++)
            if(map.containsKey(i)) {
                List<int[]> l = map.get(i);
                for(int[] p:l) 
                    res[k++]=p;
            }
        return res;
    }
}

