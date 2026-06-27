// https://leetcode.com/problems/bus-routes/description/
// using BFS on stops as nodes
// t.c.=O(S), s.c.=O(S+N), where S=total number of stops, N=total number of routes
class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source==target)  return 0;
        Map<Integer, List<Integer>> stopToRoutes=new HashMap<>();
        Set<Integer> visitedStops=new HashSet<>(), visitedRoutes=new HashSet<>();
        Queue<Integer> queue=new LinkedList<>();
        int totalRoutes=routes.length, leastBuses=0;
        for(int route=0;route<totalRoutes;route++)
            for(int stop:routes[route])
                stopToRoutes.computeIfAbsent(stop, k->new ArrayList()).add(route);
        queue.offer(source);
        visitedStops.add(source);
        while(!queue.isEmpty()) {
            leastBuses++;
            int levelSize=queue.size();
            while(levelSize-->0) {
                int stop=queue.poll();
                for(int route:stopToRoutes.getOrDefault(stop, new ArrayList<>())) {
                    if(visitedRoutes.contains(route))    continue;
                    visitedRoutes.add(route);
                    for(int nextStop:routes[route]) {
                        if(nextStop==target)    return leastBuses;
                        if(visitedStops.add(nextStop))
                            queue.offer(nextStop);
                    }
                }
            }
        }
        return -1;
    }
}

// using routes as nodes in BFS
// t.c.=O(N*S), s.c.=O(N+S)
class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source==target)  return 0;
        Map<Integer, List<Integer>> stopToRoutes=new HashMap<>();
        Set<Integer> visitedStops=new HashSet<>(), visitedRoutes=new HashSet<>();
        Set<Integer> targetRoutes=new HashSet<>();
        Queue<Integer> queue=new LinkedList<>();
        int totalRoutes=routes.length, leastBuses=1;
        for(int route=0;route<totalRoutes;route++)
            for(int stop:routes[route])
                stopToRoutes.computeIfAbsent(stop, k->new ArrayList()).add(route);
        for(int routeIdx:stopToRoutes.getOrDefault(target, new ArrayList<>()))
            targetRoutes.add(routeIdx);
        for(int routeIdx:stopToRoutes.getOrDefault(source, new ArrayList<>())) {
            queue.offer(routeIdx);
            visitedRoutes.add(routeIdx);
        }
        while(!queue.isEmpty()) {
            int levelSize=queue.size();
            while(levelSize-->0) {
                int route=queue.poll();
                if(targetRoutes.contains(route))    return leastBuses;
                for(int stop:routes[route])
                    for(int neighbor:stopToRoutes.get(stop))
                        if(!visitedRoutes.contains(neighbor)) {
                            visitedRoutes.add(neighbor);
                            queue.offer(neighbor);
                        }
            }
            leastBuses++;
        }
        return -1;
    }
}
