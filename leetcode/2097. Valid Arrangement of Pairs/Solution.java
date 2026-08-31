// https://leetcode.com/problems/valid-arrangement-of-pairs/description
// using backtracking
// t.c.=O(n! * n), s.c.=O(n)
class Solution {
    public int[][] validArrangement(int[][] pairs) {
        int len=pairs.length;
        int[][] result=new int[len][2];
        boolean[] used=new boolean[len];
        for(int i=0;i<len;i++) {
            used[i]=true;
            result[0]=pairs[i];
            if(backtrack(pairs, result, used, 1, len))
                return result;
            used[i]=false;
        }
        return result;
    }
    private boolean backtrack(int[][] pairs, int[][] result, boolean[] used, int pos, int len) {
        if(pos==len)    return true;
        int lastEnd=result[pos-1][1];
        for(int i=0;i<len;i++) {
            if(!used[i] && pairs[i][0]==lastEnd) {
                used[i]=true;
                result[pos]=pairs[i];
                if(backtrack(pairs, result, used, pos+1, len))
                    return true;
                used[i]=false;
            }
        }
        return false;
    }
}

// using Hierholzer's algo
// t.c.=O(V+E), s.c.=O(V+E)
class Solution {
    public int[][] validArrangement(int[][] pairs) {
        // building the directed graph
        // t.c.=O(E)=O(n), s.c.=O(E+V)
        Map<Integer, List<Integer>> graph=new HashMap<>();
        Map<Integer, Integer> degree=new HashMap<>();
        for(int[] pair:pairs) {
            graph.computeIfAbsent(pair[0], k->new LinkedList<>()).add(pair[1]);
            // 1 for out-degree, -1 for in-degree
            degree.merge(pair[0], 1, Integer::sum);
            degree.merge(pair[1], -1, Integer::sum);
        }
        // find the starting node
        // t.c.=O(V)
        int start=pairs[0][0];
        for(Map.Entry<Integer, Integer> entry:degree.entrySet())
            if(entry.getValue()==1) {
                start=entry.getKey();
                break;
            }
        // Hierholzer's algorithm
        // t.c.=O(E), s.c.=O(V)
        List<Integer> path=new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
        stack.push(start);
        while(!stack.isEmpty()) {
            int node=stack.peek();
            if(graph.containsKey(node) && !graph.get(node).isEmpty())
                stack.push(graph.get(node).removeFirst());
            else
                path.add(stack.pop());
        }
        Collections.reverse(path);  // t.c.=O(V)
        // build the result array from the Eulerian path
        int len=pairs.length;
        int[][] result=new int[len][2];
        for(int i=0;i<len;i++) {
            result[i][0]=path.get(i);
            result[i][1]=path.get(i+1);
        }
        return result;
    }
}
