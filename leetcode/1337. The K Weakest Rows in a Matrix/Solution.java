// Using extra space
// t.c.=O(m(n+logm)), s.c.=O(m)
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m=mat.length;
        int n=mat[0].length;
        int[][] arr = new int[m][2];
        for(int i=0;i<m;i++) {
            int cnt = 0;
            for(int j=0;j<n;j++)
                if(mat[i][j]==1)
                    cnt++;
                else
                    break;
            arr[i][0]=i;
            arr[i][1]=cnt;
        }
        Arrays.sort(arr, (a,b)->(a[1]-b[1]));
        int[] res = new int[k];
        for(int i=0;i<k;i++)
            res[i]=arr[i][0];
        return res;
    }
}

// Using hashmap
// t.c.=O(mn), s.c.=O(max(m,n))
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m=mat.length;
        int n=mat[0].length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<m;i++) {
            int cnt = 0;
            for(int j=0;j<n;j++)
                if(mat[i][j]==1)
                    cnt++;
                else
                    break;
            if(!map.containsKey(cnt))
                map.put(cnt, new ArrayList<>());
            map.get(cnt).add(i);
        }
        int[] res = new int[k];
        int j=0;
        for(int i=0;i<=n;i++) {
            if(map.containsKey(i))
                for(int index:map.get(i)) {
                    res[j++]=index;
                    if(j==k)
                        break;
                }
            if(j==k)
                break;
        }
        return res;
    }
}

// Traversing column wise
// t.c.=O(mn), s.c.=O(1)
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m=mat.length;
        int n=mat[0].length;
        int[] res = new int[k];
        int cnt=0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(mat[j][i]==0) {
                    if(i==0)
                        res[cnt++]=j;
                    else if(mat[j][i-1]==1)
                        res[cnt++]=j;
                }
                if(cnt==k)
                    break;
            }
            if(cnt==k)
                break;
        }
        if(cnt<k)
            for(int i=0;i<m;i++){
                if(mat[i][n-1]==1)
                    res[cnt++]=i;
                if(cnt==k)
                    break;
            }
        return res;
    }
}
