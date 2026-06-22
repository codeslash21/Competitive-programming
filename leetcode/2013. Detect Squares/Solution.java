// https://leetcode.com/problems/detect-squares/description/
// using hashmap
// t.c.=O(1) for add, O(n) for count, s.c.=O(n)
class DetectSquares {
    private Map<Integer, Map<Integer, Integer>> points;
    public DetectSquares() {
        points=new HashMap<>();
    }
    
    public void add(int[] point) {
        int x=point[0], y=point[1];
        points.putIfAbsent(x, new HashMap<>());
        points.get(x).put(y, points.get(x).getOrDefault(y, 0)+1);
    }
    
    public int count(int[] point) {
        int x1=point[0], y1=point[1], res=0;
        if(!points.containsKey(x1))  return res;
        for(int y2:points.get(x1).keySet()) {
            int side=y2-y1;
            if(side==0) continue;
            int x3=x1+side, x4=x1-side;
            res+=points.get(x1).get(y2)*
                 points.getOrDefault(x3, new HashMap<>()).getOrDefault(y1, 0)*
                 points.getOrDefault(x3, new HashMap<>()).getOrDefault(y2, 0);
            res+=points.get(x1).get(y2)*
                 points.getOrDefault(x4, new HashMap<>()).getOrDefault(y1, 0)*
                 points.getOrDefault(x4, new HashMap<>()).getOrDefault(y2, 0);
        }
        return res;
    }
}
