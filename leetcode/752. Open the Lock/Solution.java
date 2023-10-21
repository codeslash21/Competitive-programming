// using bfs
// t.c.=O(A^N + N + D), s.c.=O(A^N + D), where A is the number of digits in our alphabet and N is the number of digits in lock.
class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(), seen = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        int depth=0;
        for(String d:deadends)
            dead.add(d);
        queue.offer("0000");
        seen.add("0000");
        while(!queue.isEmpty()) {
            depth++;
            int len = queue.size();
            for(int j=0;j<len; j++) {
                String curr = queue.poll();
                if(curr.equals(target))
                    return depth-1;
                if(!dead.contains(curr)) {
                    for(int i=0;i<4; i++)
                        for(int d=-1;d<=1;d+=2) {
                            int y=((curr.charAt(i)-'0')+d+10)%10;
                            String nei = curr.substring(0,i)+(""+y)+curr.substring(i+1);
                            if(!seen.contains(nei)) {
                                seen.add(nei);
                                queue.offer(nei);
                            }
                        }
                }
            }
        }
        return -1;
    }
}
