// t.c.=O(m*n), s.c.=O(m+n)
class Solution {
    public boolean isToeplitzMatrix(int[][] mat) {
        Map<Integer, Integer> map = new HashMap<>();
        int r=mat.length, c=mat[0].length;
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++) {
                if(!map.containsKey(i-j))
                    map.put(i-j, mat[i][j]);
                else if(mat[i][j]!=map.get(i-j))
                    return false;
            }
        return true;
    }
}

// t.c.=O(m*n), s.c.=O(1)
class Solution {
    public boolean isToeplitzMatrix(int[][] mat) {
        int r=mat.length, c=mat[0].length;
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
                if(i>0 && j>0 && mat[i][j]!=mat[i-1][j-1])
                    return false;
        return true;
    }
}
