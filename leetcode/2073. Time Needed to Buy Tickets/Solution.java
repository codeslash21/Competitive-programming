// t.c.=O(n), s.c.=O(1)
class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int res=0, target=tickets[k], n=tickets.length;
        for(int i=0;i<n;i++)
            if(i<=k)
                if(tickets[i]<target)
                    res+=tickets[i];
                else
                    res+=target;
            else
                if(tickets[i]<target-1)
                    res+=tickets[i];
                else
                    res+=(target-1);
        return res;
    }
}
