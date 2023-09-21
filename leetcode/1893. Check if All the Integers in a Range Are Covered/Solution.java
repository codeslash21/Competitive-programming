// t.c.=O(n), s.c.=O(1)
class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] covered = new int[52];
        for(int[] range:ranges) {
            covered[range[0]]++;
            covered[range[1]+1]--;
        }
        for(int i=1, overlap=0;i<=right;i++) {
            overlap+=covered[i];
            if(i>=left && overlap==0)
                return false;
        }
        return true;
    }
}

