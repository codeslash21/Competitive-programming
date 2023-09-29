// Usinng sliding window
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n=customers.length, sum=0, satis=0, maxSatis=0;
        for(int i=0;i<n;i++)
            sum+=(grumpy[i]==0? customers[i]:0);
        for(int i=0;i<minutes-1 && i<n; i++)
            satis+=(grumpy[i]==1?customers[i]:0);
        for(int i=minutes-1;i<n;i++) {
            satis+=(grumpy[i]==1?customers[i]:0);
            if(maxSatis<satis)
                maxSatis=satis;
            satis-=(grumpy[i+1-minutes]==1?customers[i+1-minutes]:0);
        }
        return sum+maxSatis;
    }
}
