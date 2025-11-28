// https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/description/
// bruteforce
// t.c.=O(nk), s.c.=O(k)
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int k=nums.size();
        int[] indices=new int[k], range={0, Integer.MAX_VALUE};
        while(true) {
            int minEle=Integer.MAX_VALUE, maxEle=Integer.MIN_VALUE, minIdx=0;
            for(int i=0;i<k;i++) {
                int ele=nums.get(i).get(indices[i]);
                if(ele<minEle) {
                    minEle=ele;
                    minIdx=i;
                }
                if(maxEle<ele)
                    maxEle=ele;
            }
            if(maxEle-minEle<range[1]-range[0]) {
                range[0]=minEle;
                range[1]=maxEle;
            }
            if(++indices[minIdx]==nums.get(minIdx).size())
                break;
        }
        return range;
    }
}

// minHeap
// t.c.=O(nlogk), s.c.=O(k)
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int k=nums.size(), rangeStart=0, rangeEnd=Integer.MAX_VALUE, maxVal=Integer.MIN_VALUE;
        PriorityQueue<int[]> minHeap=new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0;i<k;i++) {
            minHeap.offer(new int[]{nums.get(i).get(0), i, 0});
            maxVal=Math.max(maxVal, nums.get(i).get(0));
        }
        while(minHeap.size()==k) {
            int[] root=minHeap.poll();
            int minVal=root[0], row=root[1], col=root[2];
            if(maxVal-minVal<rangeEnd-rangeStart) {
                rangeStart=minVal;
                rangeEnd=maxVal;
            }
            if(col+1<nums.get(row).size()) {
                minHeap.offer(new int[] {nums.get(row).get(col+1), row, col+1});
                maxVal=Math.max(maxVal, nums.get(row).get(col+1));
            }
        }
        return new int[]{rangeStart, rangeEnd};
    }
}
