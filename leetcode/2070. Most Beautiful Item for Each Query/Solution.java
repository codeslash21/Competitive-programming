// https://leetcode.com/problems/most-beautiful-item-for-each-query/description/
// Using sorting + binary search
// t.c.=O((n+m)logn), s.c.=O(logn), n=len(items), m=len(queries)
class Solution {
    public int binarySearch(int[][] items, int targetPrice) {
        int len=items.length, maxBeauty=0, left=0, right=len-1;
        while(left<=right) {
            int mid=left+(right-left)/2;
            if(items[mid][0]>targetPrice)
                right=mid-1;
            else {
                maxBeauty=Math.max(maxBeauty, items[mid][1]);
                left=mid+1;
            }
        }
        return maxBeauty;
    }
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int len=items.length, queryLen=queries.length, maxBeauty=Integer.MIN_VALUE;
        int[] res=new int[queryLen];
        Arrays.sort(items, (a,b)->a[0]-b[0]);
        for(int i=0;i<len;i++) {
            maxBeauty=Math.max(maxBeauty, items[i][1]);
            items[i][1]=maxBeauty;
        }
        for(int i=0;i<queryLen;i++) 
            res[i]=binarySearch(items, queries[i]);
        return res;
    }
}

// Sorting items + sorting queries
// t.c.=O(nlogn + mlogm), s.c.=O(logn + logm + m)
class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int itemLen=items.length, queryLen=queries.length, itemIdx=0, maxBeauty=0;
        int[][] queriesWithIndices=new int[queryLen][2];
        int[] res=new int[queryLen];
        for(int i=0;i<queryLen;i++) {
            queriesWithIndices[i][0]=queries[i];
            queriesWithIndices[i][1]=i;
        }
        Arrays.sort(items, (a,b)->a[0]-b[0]);
        Arrays.sort(queriesWithIndices, (a,b)->a[0]-b[0]);
        for(int i=0;i<queryLen;i++) {
            int targetPrice=queriesWithIndices[i][0], originalIdx=queriesWithIndices[i][1];
            while(itemIdx<itemLen && items[itemIdx][0]<=targetPrice) 
                maxBeauty=Math.max(maxBeauty, items[itemIdx++][1]);
            res[originalIdx]=maxBeauty;
        }
        return res;
    }
}
