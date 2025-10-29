// https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store/description/
// t.c.=O(NlogV), s.c.=O(1), N=len(quantities), V=max(quantities)
class Solution {
    public int maxPossibleStore(int[] quantities, int amount) {
        int count=0;
        for(int quantity:quantities)
            count+=Math.ceil((double)quantity/amount);
        return count;
    }
    public int minimizedMaximum(int n, int[] quantities) {
        int len=quantities.length, left=0, right=Arrays.stream(quantities).max().getAsInt();
        while(left<right) {
            int mid=left+(right-left)/2;
            if(maxPossibleStore(quantities, mid)<=n)
                right=mid;
            else
                left=mid+1;
        }
        return left;
    }
}
