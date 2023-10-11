// using dfs
// t.c.=O(V+E), s.c.=O(V+E)
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        int[] found = new int[n];
        found[0]=1;
        helper(rooms, found, 0);
        for(int i=0;i<n;i++)
            if(found[i]!=1)
                return false;
        return true;
    }
    private void helper(List<List<Integer>> rooms, int[] found,  int curr) {
        for(int k:rooms.get(curr)) {
            if(found[k]!=1) {
                found[k]=1;
                helper(rooms, found, k);
            }
        }
    }
}
