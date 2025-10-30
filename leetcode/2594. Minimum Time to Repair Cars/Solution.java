// https://leetcode.com/problems/minimum-time-to-repair-cars/description/
// t.c.=O(Nlogn), s.c.=O(1), N=len(ranks), n=number of cars
class Solution {
    public long carRepaired(int[] ranks, long maxTime) {
        long carRepaired=0;
        for(int rank:ranks) 
            carRepaired+=(int)Math.floor(Math.sqrt(maxTime/rank));
        return carRepaired;
    }
    public long repairCars(int[] ranks, int cars) {
        long left=1, right=100*(long)Math.pow(cars, 2);
        while(left<right) {
            long mid=left+(right-left)/2;
            if(carRepaired(ranks, mid)<cars)
                left=mid+1;
            else
                right=mid;
        }
        return left;
    }
}
