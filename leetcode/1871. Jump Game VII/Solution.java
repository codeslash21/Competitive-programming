// https://leetcode.com/problems/jump-game-vii/description/
// using bfs
// t.c.=O(n^2), s.c.=O(n)
class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int len=s.length();
        boolean[] visited=new boolean[len];
        Queue<Integer> queue=new LinkedList<>();
        visited[0]=true;
        queue.offer(0);
        while(!queue.isEmpty()) {
            int index=queue.poll();
            for(int j=index+minJump;j<=Math.min(index+maxJump, len-1);j++) 
                if(!visited[j] && s.charAt(j)=='0') {
                    if(j==len-1)    return true;
                    queue.offer(j);
                    visited[j]=true;
                }
        }
        return false;
    }
}
