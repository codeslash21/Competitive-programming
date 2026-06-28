// https://leetcode.com/problems/course-schedule-iv/description/
// using Floyd warshall
// t.c.=O(n^3), s.c.=O(n^2)
class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] reachable=new boolean[numCourses][numCourses];
        List<Boolean> res=new ArrayList<>();
        for(int[] pair:prerequisites)
            reachable[pair[0]][pair[1]]=true;
        for(int i=0;i<numCourses;i++)
            for(int k=0;k<numCourses;k++)
                for(int j=0;j<numCourses;j++)
                    if(reachable[i][k] && reachable[k][j])
                        reachable[i][j]=true;
        for(int[] query:queries)
            res.add(reachable[query[0]][query[1]]);
        return res;
    }
}

// using Kahn's algorithm
// t.c.=O(V*E + Q), s.c.=O(V^2 + E)
class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int[] indegree=new int[numCourses];
        Map<Integer, List<Integer>> dependents=new HashMap<>();
        Set<Integer>[] ancestors=new HashSet[numCourses];
        Queue<Integer> queue=new LinkedList<>();
        List<Boolean> res=new ArrayList<>();
        for(int[] pair:prerequisites) {
            dependents.computeIfAbsent(pair[0], k->new ArrayList<>()).add(pair[1]);
            indegree[pair[1]]++;
        }
        for(int course=0;course<numCourses;course++) {
            if(indegree[course]==0) queue.offer(course);
            ancestors[course]=new HashSet<>();
        }
        while(!queue.isEmpty()) {
            int course=queue.poll();
            for(int neighbor:dependents.getOrDefault(course, new ArrayList<>())) {
                ancestors[neighbor].add(course);
                ancestors[neighbor].addAll(ancestors[course]);
                indegree[neighbor]--;
                if(indegree[neighbor]==0)   queue.offer(neighbor);
            }
        }
        for(int[] query:queries)
            res.add(ancestors[query[1]].contains(query[0]));
        return res;
    }
}
