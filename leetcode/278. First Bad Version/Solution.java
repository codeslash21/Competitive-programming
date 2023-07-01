// using binary search
// t.c.=O(logn), s.c.=O(1)
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int res=Integer.MAX_VALUE, left=1, right=n;
        while(left<=right) {
            int mid=left+(right-left)/2;
            if(isBadVersion(mid)) {
                res=Math.min(res, mid);
                right=mid-1;
            }
            else
                left=mid+1;
        }
        return res;
    }
}
