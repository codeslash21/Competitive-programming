// https://leetcode.com/problems/find-in-mountain-array/description/
// binary search
// t.c.=O(logn), s.c.=O(1)
/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findPeak(MountainArray mountainArr) {
        int left=1, right=mountainArr.length()-2;
        while(left<right) {
            int mid=left+(right-left)/2;
            if(mountainArr.get(mid)<mountainArr.get(mid+1))
                left=mid+1;
            else
                right=mid;
        }
        return left;
    }
    public int findInIncreasingSlope(MountainArray mountainArr, int target, int left, int right) {
        while(left<right) {
            int mid=left+(right-left)/2;
            if(mountainArr.get(mid)<target)
                left=mid+1;
            else
                right=mid;
        }
        return mountainArr.get(left)==target?left:-1;
    }
    public int findInDecreasingSlope(MountainArray mountainArr, int target, int left, int right) {
        while(left<right) {
            int mid=left+(right-left)/2;
            if(mountainArr.get(mid)>target)
                left=mid+1;
            else
                right=mid;
        }
        return mountainArr.get(left)==target?left:-1;
    }
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len=mountainArr.length();
        int peakIndex=findPeak(mountainArr);
        int indexOnIncreasingSlope=findInIncreasingSlope(mountainArr, target, 0, peakIndex);
        if(indexOnIncreasingSlope>=0)
            return indexOnIncreasingSlope;
        return findInDecreasingSlope(mountainArr, target, peakIndex+1, len-1);
    }
}

