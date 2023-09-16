// Using array
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] rem = new int[60];
        int cnt=0;
        for(int t:time) {
            if(t%60==0)
                cnt+=rem[0];
            else
                cnt+=rem[60-t%60];
            rem[t%60]++;
        }
        return cnt;
    }
}
