// https://leetcode.com/problems/sqrtx/description/
class Solution {
    public int mySqrt(int x) {
        int left=1, right=x/2+1, res=0;
        if(x==0)
            return 0;
        while(left<=right) {
            int mid=left+(right-left)/2;
            long prod=(long)mid*mid;
            if(prod>x)
                right=mid-1;
            else if(prod<x) {
                left=mid+1;
                res=mid;
            } else
                return mid;
        }
        return res;
    }
}
