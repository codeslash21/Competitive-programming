// https://leetcode.com/problems/h-index-ii/description/
// using binary search
// t.c.=O(logn), s.c.=O(1)
class Solution {
    public int hIndex(int[] citations) {
        int len=citations.length, left=1, right=len, res=0;
        if(citations[len-1]==0) return res;
        while(left<=right) {
            int mid=left+(right-left)/2;
            if(citations[len-mid]>=mid) {
                res=mid;
                left=mid+1;
            } else 
                right=mid-1;
        }
        return res;
    }
}
