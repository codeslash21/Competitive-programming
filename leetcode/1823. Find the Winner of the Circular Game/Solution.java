// https://leetcode.com/problems/find-the-winner-of-the-circular-game/description
// using queue
// t.c.=O(n*k), s.c.=O(k)
class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue=new LinkedList<>();
        for(int i=1;i<=n;i++)
            queue.offer(i);
        while(queue.size()>1) {
            for(int i=0;i<k-1;i++)
                queue.offer(queue.remove());
            queue.remove();
        }
        return queue.peek();
    }
}

// using recursion
// t.c.=O(n), s.c.=O(n)
class Solution {
    public int findTheWinner(int n, int k) {
        return winnerHelper(n, k)+1;
    }
    private int winnerHelper(int n, int k) {
        if(n==1)    return 0;
        return (winnerHelper(n-1, k)+k)%n;
    }
}

// using iterative approach
// t.c.=O(n), s.c.=O(1)
class Solution {
    public int findTheWinner(int n, int k) {
        int winner=0;
        for(int i=2;i<=n;i++)
            winner=(winner+k)%i;
        return winner+1;
    }
}
