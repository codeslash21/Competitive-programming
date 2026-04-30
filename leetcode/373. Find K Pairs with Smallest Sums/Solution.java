// https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/
// t.c.=O(k*log(min(k,m)), s.c.=O(min(k,m), m=len(nums1), n=len(nums2)
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int len1=nums1.length, len2=nums2.length;
        List<List<Integer>> result=new ArrayList<>();
        PriorityQueue<int[]> minHeap=new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0;i<Math.min(k, len1);i++)
            minHeap.offer(new int[] {nums1[i]+nums2[0], i, 0});
        while(!minHeap.isEmpty() && result.size()<k) {
            int[] top=minHeap.poll();
            int firstIdx=top[1], secondIdx=top[2];
            result.add(Arrays.asList(nums1[firstIdx], nums2[secondIdx]));
            if(secondIdx+1<len2)
                minHeap.offer(new int[]{nums1[firstIdx]+nums2[secondIdx+1], firstIdx, secondIdx+1});
        }
        return result;
    }
}
