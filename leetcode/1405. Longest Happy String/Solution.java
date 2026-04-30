// https://leetcode.com/problems/longest-happy-string/description/
// t.c.=O(nlogk), s.c.=O(k), k=number of distinct chars
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> maxHeap=new PriorityQueue<>((x,y)->y[0]-x[0]);
        StringBuilder sb=new StringBuilder();
        if(a>0) maxHeap.offer(new int[]{a, 'a'});
        if(b>0) maxHeap.offer(new int[]{b, 'b'});
        if(c>0) maxHeap.offer(new int[]{c, 'c'});
        while(!maxHeap.isEmpty()) {
            int[] top=maxHeap.poll();
            int len=sb.length();
            char ch=(char)top[1];
            if(len>=2 && sb.charAt(len-1)==ch && sb.charAt(len-2)==ch) {
                if(maxHeap.isEmpty())   break;
                int[] second=maxHeap.poll();
                sb.append((char)second[1]);
                second[0]--;
                if(second[0]>0) maxHeap.offer(second);
                maxHeap.offer(top);
            } else {
                sb.append(ch);
                top[0]--;
                if(top[0]>0)    maxHeap.offer(top);
            }
        }
        return sb.toString();
    }
}
