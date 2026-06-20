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

// using dp
// t.c.=O(n^2), s.c.=O(n)
class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int len=stations.length, minStops=Integer.MAX_VALUE;
        int[] dp=new int[len+1];
        dp[0]=startFuel;
        for(int i=0;i<len;i++)
            for(int k=i;k>=0;k--) {
                if(dp[k]>=stations[i][0])
                    dp[k+1]=Math.max(dp[k+1], dp[k]+stations[i][1]);
            }
        for(int i=0;i<=len;i++)
            if(dp[i]>=target)
                minStops=Math.min(minStops, i);
        return minStops==Integer.MAX_VALUE?-1:minStops;
    }
}

// using maxHeap
// t.c.=O(nlogn), s.c.=O(n)
class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int len=stations.length, reach=startFuel, stops=0;
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<=len;i++) {
            int nextPosition=i<len?stations[i][0]:target;
            while(reach<nextPosition && !maxHeap.isEmpty()) {
                reach+=maxHeap.poll();
                stops++;
            }
            if(reach<nextPosition)  return -1;
            if(i<len)   maxHeap.offer(stations[i][1]);
        }
        return stops;
    }
}
