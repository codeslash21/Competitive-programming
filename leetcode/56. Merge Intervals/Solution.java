// Using graph and connected components concept
// t.c.=O(n^2), s.c.=O(n^2)
class Solution {
    private Map<int[], List<int[]>> graph;
    private Map<Integer, List<int[]>> nodesInComp;
    private Set<int[]> visited;

    private boolean overlap(int[] a, int[] b) {
        return a[0]<=b[1] && b[0]<=a[1];
    }
    private void buildGraph(int[][] intervals) {
        graph=new HashMap<>();
        for(int[] interval:intervals) 
            graph.put(interval, new LinkedList<>());
        for(int[] interval1:intervals)
            for(int[] interval2:intervals)
                if(overlap(interval1, interval2)) {
                    graph.get(interval1).add(interval2);
                    graph.get(interval2).add(interval1);
                }
    }
    private void markComponentsDFS(int[] start, int compNumber) {
        Stack<int[]> stack = new Stack<>();
        stack.add(start);
        while(!stack.isEmpty()) {
            int[] node = stack.pop();
            if(!visited.contains(node)) {
                visited.add(node);
                if(nodesInComp.get(compNumber)==null) 
                    nodesInComp.put(compNumber, new LinkedList<>());
                nodesInComp.get(compNumber).add(node);
                for(int[] child:graph.get(node))
                    stack.add(child);
            }
        }
    }
    private void buildComponents(int[][] intervals) {
        nodesInComp = new HashMap<>();
        visited = new HashSet<>();
        int compNumber=0;
        for(int[] interval:intervals) 
            if(!visited.contains(interval)) {
                markComponentsDFS(interval, compNumber);
                compNumber++;
            }
    }
    private int[] mergeNodes(List<int[]> nodes) {
        int minStart=nodes.get(0)[0];
        for(int[] node:nodes)
            minStart=Math.min(minStart, node[0]);
        int maxEnd=nodes.get(0)[0];
        for(int[] node:nodes) 
            maxEnd=Math.max(maxEnd, node[1]);
        return new int[] {minStart, maxEnd};
    }
    public int[][] merge(int[][] intervals) {
        buildGraph(intervals);
        buildComponents(intervals);
        List<int[]> merged = new LinkedList<>();
        for(int comp=0; comp<nodesInComp.size(); comp++)
            merged.add(mergeNodes(nodesInComp.get(comp)));
        return merged.toArray(new int[merged.size()][]);
    }
}

// Using sorting
//t.c.=O(nlogn), s.c.=O(logn) for sorting
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for(int[] interval:intervals) {
            if(merged.isEmpty() || merged.getLast()[1]<interval[0])
                merged.add(interval);
            else
                merged.getLast()[1]=Math.max(merged.getLast()[1], interval[1]);
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
