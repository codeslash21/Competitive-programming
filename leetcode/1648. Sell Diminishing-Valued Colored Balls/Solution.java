// https://leetcode.com/problems/sell-diminishing-valued-colored-balls/description/
// using greedy approach
// t.c.=O(nlogn), s.c.=O(logn)
class Solution {
    public int maxProfit(int[] inventory, int orders) {
        int len=inventory.length, n=len-1;
        long totalValue=0, mod=1000000007, count=1;
        Arrays.sort(inventory);
        while(orders>0) {
            if(n>0 && inventory[n]-inventory[n-1]>0 && orders>=(count*(inventory[n]-inventory[n-1]))) {
                totalValue+=count*rangeSum(inventory[n], inventory[n-1]);
                orders-=count*(inventory[n]-inventory[n-1]);
            } else if(n==0 || inventory[n]-inventory[n-1]>0) {
                long res=orders/count, rem=orders%count;
                totalValue+=count*rangeSum(inventory[n], inventory[n]-res);
                totalValue+=rem*(inventory[n]-res);
                orders=0;
            }
            totalValue%=mod;
            n--;    count++;
        }
        return (int)totalValue;
    }
    private long rangeSum(long start, long end) {
        long sum=(start*(start+1))/2 - (end*(end+1))/2;
        return sum;
    }
}
