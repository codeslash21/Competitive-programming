// https://leetcode.com/problems/high-five/description/
// using map and minHeap
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map=new HashMap<>();
        for(int[] item:items) {
            int id=item[0], score=item[1];
            map.computeIfAbsent(id, k->new PriorityQueue<>()).add(score);
            if(map.get(id).size()>5)
                map.get(id).poll();
        }
         int totalStudents=map.size(), idx=0;
        int[][] res=new int[totalStudents][2];
        for(Map.Entry<Integer, PriorityQueue<Integer>> entry:map.entrySet()) {
            int id=entry.getKey(), totalScore=0;
            PriorityQueue<Integer> scores=entry.getValue();
            while(!scores.isEmpty())
                totalScore+=scores.poll();
            res[idx++]=new int[]{id, totalScore/5};
        }
        return res;
    }
}
