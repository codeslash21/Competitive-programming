// https://leetcode.com/problems/count-paths-that-can-form-a-palindrome-in-a-tree/description
// using dfs
// t.c.=O(n), s.c.=O(n)
class Solution {
    private long dfs(Map<Integer, List<Integer>> graph, Map<Integer, Integer> bitMasks, Integer currNode, Integer currBitMask, String s) {
        long res=0;
        for(Integer child:graph.getOrDefault(currNode, new ArrayList<>())) {
            char ch=s.charAt(child);
            int childBitMask=currBitMask ^ (1<<(ch-'a'));
            // find the node v which has equal bit mask
            res+=bitMasks.getOrDefault(childBitMask, 0);
            // find the node v whose bit mask differs by 1 bit
            for(int i=1<<25;i>0;i>>=1) {
                int newBitMask=childBitMask ^ i;
                res+=bitMasks.getOrDefault(newBitMask, 0);
            }
            bitMasks.put(childBitMask, bitMasks.getOrDefault(childBitMask, 0)+1);
            res+=dfs(graph, bitMasks, child, childBitMask, s);
        }
        return res;
    }
    public long countPalindromePaths(List<Integer> parent, String s) {
        int nodes=parent.size();
        Map<Integer, Integer> bitMasks=new HashMap<>();
        bitMasks.put(0, 1);
        // build the graph, t.c.=O(n), s.c.=O(n)
        Map<Integer, List<Integer>> graph=new HashMap<>();
        for(int i=1;i<nodes;i++) 
            graph.computeIfAbsent(parent.get(i), k->new ArrayList<>()).add(i);
        // dfs takes t.c.=O(n*26), s.c.=O(n) for recursion stack and bitMasks
        return dfs(graph, bitMasks, 0, 0, s);
    }
}
