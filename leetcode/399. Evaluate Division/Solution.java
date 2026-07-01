// https://leetcode.com/problems/evaluate-division/description/
// using BFS
// t.c.=O(Q*(V+E)), s.c.=O(V+E)
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<String>> neighbors=new HashMap<>();
        Map<String, List<Double>> weights=new HashMap<>();
        double[] answer=new double[queries.size()];
        for(int i=0;i<equations.size();i++) {
            String a=equations.get(i).get(0);
            String b=equations.get(i).get(1);
            double value=values[i];
            neighbors.computeIfAbsent(a, k->new ArrayList<>()).add(b);
            neighbors.computeIfAbsent(b, k->new ArrayList<>()).add(a);
            weights.computeIfAbsent(a, k->new ArrayList<>()).add(value);
            weights.computeIfAbsent(b, k->new ArrayList<>()).add(1.0/value);
        }
        for(int idx=0;idx<queries.size();idx++) {
            answer[idx]=dfs(queries.get(idx).get(0), queries.get(idx).get(1), neighbors, weights);
        }
        return answer;
    }
    private double dfs(String src, String dest, Map<String, List<String>> neighbors, Map<String, List<Double>> weights) {
        if(!neighbors.containsKey(src) || !neighbors.containsKey(dest))   return -1.0;
        if(src.equals(dest))   return 1.0;
        Queue<Object[]> queue=new LinkedList<>();
        Set<String> visited=new HashSet<>();
        queue.offer(new Object[]{src, 1.0});
        visited.add(src);
        while(!queue.isEmpty()) {
            Object[] current=queue.poll();
            String node=(String) current[0];
            Double product=(double) current[1];
            List<String> nodeNeighbors=neighbors.get(node);
            List<Double> nodeWeights=weights.get(node);
            for(int i=0;i<nodeNeighbors.size();i++) {
                String neighbor=nodeNeighbors.get(i);
                double weight=nodeWeights.get(i);
                if(visited.contains(neighbor))  continue;
                Double currProduct=weight*product;
                if(neighbor.equals(dest))  return currProduct;
                queue.offer(new Object[]{neighbor, currProduct});
                visited.add(neighbor);
            }
        }
        return -1.0;
    }
}

// using Floyd-Warshall algo
// t.c.=O(m+n^3), s.c.=O(m+n^2)
public class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];
            graph.computeIfAbsent(a, k -> new HashMap<>()).put(b, value);
            graph.computeIfAbsent(b, k -> new HashMap<>()).put(a, 1.0 / value);
        }
        for (String k : graph.keySet()) {
            for (String i : graph.get(k).keySet()) {
                for (String j : graph.get(k).keySet()) {
                    graph.computeIfAbsent(i, x -> new HashMap<>()).putIfAbsent(j, graph.get(i).get(k) * graph.get(k).get(j));
                }
            }
        }
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            if (graph.containsKey(a) && graph.get(a).containsKey(b))
                result[i] = graph.get(a).get(b);
            else
                result[i] = -1.0;
        }
        return result;
    }
}
