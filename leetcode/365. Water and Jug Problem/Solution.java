// Using gcd
// t.c.=O(logn), s.c.=O(logn)
class Solution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if(targetCapacity>jug1Capacity+jug2Capacity)
            return false;
        if(targetCapacity==jug1Capacity || targetCapacity==jug2Capacity || targetCapacity==jug1Capacity+jug2Capacity)
            return true;
        if(targetCapacity%gcd(jug1Capacity, jug2Capacity)==0)
            return true;
        return false;
    }
    public int gcd(int a, int b) {
        if(b==0)
            return a;
        return gcd(b, a%b);
    }
}

// using BFS
class Solution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        int[] edges = {jug1Capacity,-jug1Capacity,jug2Capacity,-jug2Capacity};
        Set<Integer> seen = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        seen.add(0);
        while(!queue.isEmpty()) {
            int curr=queue.poll();
            for(int edge:edges) {
                int total = curr+edge;
                if(total==targetCapacity)
                    return true;
                if(total<0 || total>jug1Capacity+jug2Capacity || seen.contains(total))
                    continue;
                seen.add(total);
                queue.add(total);
            }
        }
        return false;
    }
    
}
