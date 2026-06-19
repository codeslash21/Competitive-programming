// https://leetcode.com/problems/hand-of-straights/description/
// using sorting
// t.c.=O(nlogn), s.c.=O(n)
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int len=hand.length;
        if(len%groupSize!=0)    return false;
        Map<Integer, Integer> count=new HashMap<>();
        for(int card:hand)
            count.put(card, count.getOrDefault(card, 0)+1);
        Arrays.sort(hand);
        for(int card:hand) {
            if(count.get(card)==0)  continue;
            for(int i=card;i<card+groupSize;i++) {
                if(count.getOrDefault(i, 0)==0)  return false;
                count.put(i, count.get(i)-1);
            }
        }
        return true;
    }
}

// using hashmap
// t.c.=O(n), s.c.=O(n)
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int len=hand.length;
        if(len%groupSize!=0)    return false;
        Map<Integer, Integer> count=new HashMap<>();
        for(int card:hand)
            count.put(card, count.getOrDefault(card, 0)+1);
        for(int card:hand) {
            int start=card;
            while(count.getOrDefault(start-1, 0)>0) start--;
            while(start<=card) {
                while(count.get(start)>0) {
                    for(int i=start;i<start+groupSize;i++) {
                        if(count.getOrDefault(i, 0)==0) return false;
                        count.put(i, count.get(i)-1);
                    }
                }
                start++;
            }
        }
        return true;
    }
}
