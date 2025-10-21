// https://leetcode.com/problems/valid-perfect-square/description/
// binary search t.c.=O(logn), s.c.=O(1)
class Solution {
    public boolean isPerfectSquare(int num) {
        int left=1, right=num/2+1;
        while(left<=right) {
            int mid=left+(right-left)/2;
            long prod=(long)mid*mid;
            if(prod==num)
                return true;
            else if(prod>num)
                right=mid-1;
            else
                left=mid+1;
        }
        return false;
    }
}
