// https://leetcode.com/problems/find-the-winner-of-an-array-game/description/
// using queue
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int getWinner(int[] arr, int k) {
        int len=arr.length, maxEle=arr[0], winStreak=0, curr=arr[0];
        Queue<Integer> queue=new LinkedList<>();
        for(int i=1;i<len;i++) {
            maxEle=Math.max(maxEle, arr[i]);
            queue.offer(arr[i]);
        }
        while(!queue.isEmpty()) {
            int opponent=queue.poll();
            if(curr>opponent) {
                queue.offer(opponent);
                winStreak++;
            } else {
                queue.offer(curr);
                curr=opponent;
                winStreak=1;
            }
            if(winStreak==k || curr==maxEle)
                return curr;
        }
        return -1;
    }
}

// without queue
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int getWinner(int[] arr, int k) {
        int len=arr.length, curr=arr[0], winStreak=0;
        for(int i=1;i<len;i++) {
            int opponent=arr[i];
            if(curr>opponent)
                winStreak++;
            else {
                curr=opponent;
                winStreak=1;
            }
            if(winStreak==k)    return curr;
        }
        return curr;
    }
}
