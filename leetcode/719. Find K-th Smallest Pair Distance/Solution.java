// https://leetcode.com/problems/find-k-th-smallest-pair-distance/description/
// bucket sort
// t.c.=O((n^2)*M), s.c.=O(M), M=max(nums)-min(nums)+1;
class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int len=nums.length, minElement=Integer.MAX_VALUE, maxElement=Integer.MIN_VALUE;
        for(int num:nums) {
            minElement=Math.min(minElement, num);
            maxElement=Math.max(maxElement, num);
        }
        int range=maxElement-minElement+1;
        int[] distanceBucket=new int[range];
        for(int i=0;i<len;i++)
            for(int j=i+1;j<len;j++) {
                int distance=Math.abs(nums[i]-nums[j]);
                distanceBucket[distance]++;
            }
        for(int dist=0;dist<=range;dist++) {
            k-=distanceBucket[dist];
            if(k<=0)
                return dist;
        }
        return -1;
    }
}

// binary search + sliding window
// t.c.=O(nlogn + nlogM), s.c.=O(logn)
class Solution {
    public int countPiarsWithMaxDistance(int[] nums, int dist) {
        int len=nums.length, left=0, right=0, count=0;
        for(;right<len;right++) {
            while(nums[right]-nums[left]>dist)
                left++;
            count+=right-left;
        }
        return count;
    }
    public int smallestDistancePair(int[] nums, int k) {
        int len=nums.length;
        Arrays.sort(nums);
        int left=0, right=nums[len-1]-nums[0];
        while(left<=right) {
            int mid=left+(right-left)/2;
            if(countPiarsWithMaxDistance(nums, mid)<k)
                left=mid+1;
            else
                right=mid-1;
        }
        return left;
    }
}
