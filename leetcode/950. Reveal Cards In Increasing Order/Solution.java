// https://leetcode.com/problems/reveal-cards-in-increasing-order/description/
// using queue
// t.c.=O(nlogn), s.c.=O(n)
class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int len=deck.length;
        Queue<Integer> queue=new LinkedList<>();
        int[] res=new int[len];
        Arrays.sort(deck);
        for(int i=0;i<len;i++)
            queue.add(i);
        for(int i=0;i<len;i++) {
            res[queue.poll()]=deck[i];
            if(!queue.isEmpty())
                queue.add(queue.poll());
        }
        return res;
    }
}

