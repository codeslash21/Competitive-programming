// https://leetcode.com/problems/car-fleet/description/
// sorting
// t.c.=O(nlogn), s.c.=O(n)
class Car {
    int position;
    double time;
    Car(int position, double time) {
        this.position=position;
        this.time=time;
    }
}
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int len=position.length, idx=len, cnt=0;
        Car[] cars=new Car[len];
        for(int i=0;i<len;i++) 
            cars[i]=new Car(position[i], (double)(target-position[i])/speed[i]);
        Arrays.sort(cars, (a,b)->a.position-b.position);
        while(--idx>0)
            if(cars[idx].time<cars[idx-1].time)
                cnt++;
            else
                cars[idx-1]=cars[idx];
        return cnt+1;
    }
}
