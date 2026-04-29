// https://leetcode.com/problems/furthest-building-you-can-reach/description/
// t.c.=O(2^n), s.c.=O(n)
class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        return dfs(heights, 0, bricks, ladders);
    }
    private int dfs(int[] heights, int currIdx, int bricks, int ladders) {
        if(currIdx==heights.length-1) return currIdx;
        int best=currIdx, diff=heights[currIdx+1]-heights[currIdx];
        if(diff<=0) return dfs(heights, currIdx+1, bricks, ladders);
        if(bricks>=diff)
            best=Math.max(best, dfs(heights, currIdx+1, bricks-diff, ladders));
        if(ladders>0)
            best=Math.max(best, dfs(heights, currIdx+1, bricks, ladders-1));
        return best;
    }
}

// using heap
// t.c.=O(nlogn), s.c.=O(n)
class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        for(int i=0;i<heights.length-1;i++) {
            int diff=heights[i+1]-heights[i];
            if(diff<=0) continue;
            minHeap.offer(diff);
            if(minHeap.size()>ladders)
                bricks-=minHeap.poll();
            if(bricks<0)
                return i;
        }
        return heights.length-1;
    }
}
