// https://leetcode.com/problems/maximum-candies-allocated-to-k-children/description/
// binary search, t.c.=O(logn), s.c.=O(1)
class Solution {
    private boolean canDistribute(int[] candies, int numOfCandies, long k) {
        long cnt=0;
        if(numOfCandies==0)
            return true;
        for(int candy:candies)
            cnt+=candy/numOfCandies;
        return cnt>=k;
    }
    public int maximumCandies(int[] candies, long k) {
        int left=0, right=0, res=0;
        for(int candy:candies)
            right=Math.max(right, candy);
        while(left<=right) {
            int mid=left+(right-left)/2;
            if(canDistribute(candies, mid, k)) {
                res=mid;
                left=mid+1;
            } else
                right=mid-1;
        }
        return res;
    }
}
