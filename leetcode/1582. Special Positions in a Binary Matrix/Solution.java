// using hashmap
// t.c.=O(m*n), s.c.=O(m+n)
class Solution {
    public int numSpecial(int[][] mat) {
        Map<Integer, List<Integer>> rowMap = new HashMap<>(), colMap = new HashMap<>();
        int cnt=0, m=mat.length, n=mat[0].length;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(mat[i][j]==1) {
                    if(!rowMap.containsKey(i))
                        rowMap.put(i, new ArrayList<Integer>());
                    rowMap.get(i).add(j);
                    if(!colMap.containsKey(j))
                        colMap.put(j, new ArrayList<Integer>());
                    colMap.get(j).add(i);
                }
        for(Integer key:rowMap.keySet()) {
            List<Integer> l = rowMap.get(key);
            if(l.size()==1 && colMap.get(l.get(0)).size()==1)
                cnt++;
        }
        return cnt;
    }
}
