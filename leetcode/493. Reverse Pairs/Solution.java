// https://leetcode.com/problems/reverse-pairs/description/
// using merge sort
// t.c.=O(nlogn), s.c.=O(n)
class Solution {
    private int countAndMerge(int[] nums, int left, int right) {
        if(left>=right) return 0;
        int mid=left+(right-left)/2;
        int pairCount=countAndMerge(nums, left, mid)+countAndMerge(nums, mid+1, right);
        // Count Phase: count reverse pair between two sorted halves
        int leftIdx=left, rightIdx=mid+1;
        for(;leftIdx<=mid;leftIdx++) {
            while(rightIdx<=right && nums[leftIdx]>2L*nums[rightIdx])
                rightIdx++;
            pairCount+=(rightIdx-mid-1);
        }
        // Merge Phase: merge the sorted halves
        int[] temp=new int[right-left+1];
        leftIdx=left; rightIdx=mid+1;
        int tempIdx=0;
        while(leftIdx<=mid && rightIdx<=right) {
            if(nums[leftIdx]<=nums[rightIdx])
                temp[tempIdx++]=nums[leftIdx++];
            else
                temp[tempIdx++]=nums[rightIdx++];
        }
        while(leftIdx<=mid) temp[tempIdx++]=nums[leftIdx++];
        while(rightIdx<=right)  temp[tempIdx++]=nums[rightIdx++];
        for(tempIdx=0;tempIdx<temp.length;tempIdx++)
            nums[left+tempIdx]=temp[tempIdx];
        return pairCount;
    }
    public int reversePairs(int[] nums) {
        return countAndMerge(nums, 0, nums.length-1);
    }
}
