// using brute-force method
// t.c.=O(n^2), s.c.=O(n)
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        Set<Integer> edgeSet = new HashSet<>();
        Map<Integer, Integer> edgeIdx = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        int n=buildings.length;
        for(int i=0;i<n;i++) {
            edgeSet.add(buildings[i][0]);
            edgeSet.add(buildings[i][1]);
        }
        List<Integer> edgeList = new ArrayList<>(edgeSet);
        Collections.sort(edgeList);
        int m=edgeList.size();
        for(int i=0;i<m;i++)
            edgeIdx.put(edgeList.get(i), i);
        int[] heights = new int[m];
        for(int i=0;i<n;i++) {
            int[] build = buildings[i];
            int leftIdx=edgeIdx.get(build[0]), rightIdx=edgeIdx.get(build[1]);
            int height=build[2];
            for(int j=leftIdx; j<rightIdx; j++)
                heights[j]=Math.max(heights[j], height);
        }
        for(int i=0; i<m; i++) {
            int height = heights[i], edge = edgeList.get(i);
            if(res.isEmpty() || res.get(res.size()-1).get(1)!=height)
                res.add(Arrays.asList(edge, height));
        }
        return res;
    }
}

// Using priority queue
// t.c.=O(nlogn), s.c.=O(n)
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> edges = new ArrayList<>();
        PriorityQueue<List<Integer>> live = new PriorityQueue<>((a,b)->b.get(0)-a.get(0));
        List<List<Integer>> res = new ArrayList<>();
        int n=buildings.length;
        for(int i=0; i<n; i++) {
            edges.add(Arrays.asList(buildings[i][0], i));
            edges.add(Arrays.asList(buildings[i][1], i));
        }
        Collections.sort(edges, (a,b)->a.get(0)-b.get(0));
        int idx=0, m=edges.size();
        while(idx<m) {
            int currIdx=edges.get(idx).get(0);
            while(idx<m && edges.get(idx).get(0)==currIdx) {
                int b=edges.get(idx).get(1);
                if(buildings[b][0]==currIdx) {
                    int right=buildings[b][1];
                    int height=buildings[b][2];
                    live.offer(Arrays.asList(height, right));
                }
                idx++;
            }
            while(!live.isEmpty() && live.peek().get(1)<=currIdx)
                live.poll();
            int currHeight=live.isEmpty()?0:live.peek().get(0);
            if(res.isEmpty() || res.get(res.size()-1).get(1)!=currHeight)
                res.add(Arrays.asList(currIdx, currHeight));
        }
        return res;
    }
}
