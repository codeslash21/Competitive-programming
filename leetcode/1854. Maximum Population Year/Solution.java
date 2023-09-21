// using extra array
// t.c.=O9n), s.c.=O(1)
class Solution {
    public int maximumPopulation(int[][] logs) {
        int n=logs.length, max=0, res=0;
        int[] count = new int[102];
        for(int[] arr:logs) {
            count[arr[0]-1949]++;
            count[arr[1]-1949]--;
        }
        for(int i=1;i<101;i++){
            count[i]+=count[i-1];
            if(count[i]>max) {
                max=count[i];
                res=i;
            }
        }
        return res+1949;
    }
}
