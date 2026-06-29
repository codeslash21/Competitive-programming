// https://leetcode.com/problems/sort-items-by-groups-respecting-dependencies/description/
// using topological sort
// t.c.=O(n+m+E), s.c.=O(n+m+E)
class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        int totalGroups=m;
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<n;i++)
            if(group[i]==-1)
                group[i]=totalGroups++;
        // build group graph
        Map<Integer, List<Integer>> groupGraph=new HashMap<>();
        int[] groupIndegrees=new int[totalGroups];
        for(int i=0;i<n;i++) {
            for(int prev:beforeItems.get(i))
                if(group[prev]!=group[i]) {
                    groupGraph.computeIfAbsent(group[prev], k-> new ArrayList<>()).add(group[i]);
                    groupIndegrees[group[i]]++;
                }
        }
        // sort the groups
        List<Integer> groupOrder=topologicalSort(groupGraph, groupIndegrees, totalGroups);
        // build item graph
        Map<Integer, List<Integer>> itemGraph=new HashMap<>();
        for(int item=0;item<n;item++)
            for(int prev:beforeItems.get(item))
                itemGraph.computeIfAbsent(prev, k->new ArrayList<>()).add(item);
        // build group -> members map
        Map<Integer, List<Integer>> groupToMembers=new HashMap<>();
        for(int mem=0;mem<n;mem++)
            groupToMembers.computeIfAbsent(group[mem], k->new ArrayList<>()).add(mem);
        // sort the members within the groups
        for(int grp:groupOrder) {
            List<Integer> members=groupToMembers.getOrDefault(grp, new ArrayList<>());
            if(members.isEmpty())    continue;
            Set<Integer> memberSet=new HashSet<>(members);
            int[] memberIndegrees=new int[n];
            Queue<Integer> queue=new LinkedList<>();
            for(int member:members) {
                for(int prev:beforeItems.get(member))
                    if(memberSet.contains(prev))    memberIndegrees[member]++;
            }
            for(int member:members)
                if(memberIndegrees[member]==0)
                    queue.offer(member);
            int count=0;
            while(!queue.isEmpty()) {
                int member=queue.poll();
                result.add(member);
                count++;
                for(int next:itemGraph.getOrDefault(member, new ArrayList<>()))
                    if(memberSet.contains(next)) {
                        memberIndegrees[next]--;
                        if(memberIndegrees[next]==0)    queue.offer(next);
                    }
            }
            if(count!=members.size())   return new int[0];
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    private List<Integer> topologicalSort(Map<Integer, List<Integer>> groupGraph, int[] groupIndegrees, int totalGroups) {
        Queue<Integer> queue=new LinkedList<>();
        List<Integer> result=new ArrayList<>();
        for(int group=0;group<totalGroups;group++)
            if(groupIndegrees[group]==0)    queue.offer(group);
        while(!queue.isEmpty()) {
            int group=queue.poll();
            result.add(group);
            for(int next:groupGraph.getOrDefault(group, new ArrayList<>())) {
                groupIndegrees[next]--;
                if(groupIndegrees[next]==0)
                    queue.offer(next);
            }
        }
        return totalGroups==result.size()?result:new ArrayList<>();
    }
}
