// https://leetcode.com/problems/minimum-number-of-refueling-stops/submissions/2040039669/
// t.c.=O(2^n), s.c.=O(n)
class Solution {
    int result;
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        result=Integer.MAX_VALUE;
        dfs(stations, 0, 0, startFuel, 0, target);
        return result==Integer.MAX_VALUE?-1:result;
    }
    private void dfs(int[][] stations, int index, int pos, int fuel, int stops, int target) {
        if(fuel>=target-pos) {
            result=Math.min(result, stops);
            return;
        }
        if(stops>=result)   return;
        for(int i=index;i<stations.length;i++) {
            int stationPos=stations[i][0], stationFuel=stations[i][1];
            if(fuel<stationPos-pos) break;
            dfs(stations, i+1, stationPos, fuel-stationPos+pos+stationFuel, stops+1, target);
        }
    }
}
