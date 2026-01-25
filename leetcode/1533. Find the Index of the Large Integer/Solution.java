// https://leetcode.com/problems/find-the-index-of-the-large-integer/description/
// using binary search
// t.c.=O(logn), s.c.=O(1)
class Solution {
    public int getIndex(ArrayReader reader) {
        int len=reader.length(), left=0, right=len-1;
        while(left<right) {
            int mid=left+(right-left)/2, currLen=right+1-left;
            if(currLen%2==0) {
                int res=reader.compareSub(left, mid, mid+1, right);
                if(res>0)
                    right=mid;
                else
                    left=mid+1;
            } else {
                int res=reader.compareSub(left, mid-1, mid+1, right);
                if(res>0)
                    right=mid;
                else if(res<0)
                    left=mid+1;
                else
                    return mid;
            }
        }
        return left;
    }
}
