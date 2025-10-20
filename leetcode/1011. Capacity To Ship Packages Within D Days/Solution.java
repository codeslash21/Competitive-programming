// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
class Solution {
    private boolean canShip(int[] weights, int totalCapacity, int maxDays) {
        int days=1, capacity=0;
        for(int weight:weights) {
            capacity+=weight;
            if(capacity>totalCapacity) {
                capacity=weight;
                days++;
            }
        }
        return days<=maxDays;
    }
    public int shipWithinDays(int[] weights, int days) {
        int left=0, right=0, res=Integer.MAX_VALUE;
        for(int weight:weights) {
            left=Math.max(left, weight);
            right+=weight;
        }
        while(left<=right) {
            int mid=left+(right-left)/2;
            if(canShip(weights, mid, days)) {
                res=Math.min(res, mid);
                right=mid-1;
            } else
                left=mid+1;
        }
        return res;
    }
}
