// using hashmap
// t.c.=O(difference between source and destination), s.c.=O(n)
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> passengerChange = new HashMap<Integer, Integer>();
        int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
        for(int[] trip:trips) {
            int start=passengerChange.getOrDefault(trip[1], 0)+trip[0];
            passengerChange.put(trip[1], start);
            int end=passengerChange.getOrDefault(trip[2], 0)-trip[0];
            passengerChange.put(trip[2], end);
            min=Math.min(min, trip[1]);
            max=Math.max(max, trip[2]);
        }
        int usedCapacity=0;
        for(int i=min;i<=max;i++) {
            if(passengerChange.containsKey(i))
                usedCapacity+=passengerChange.get(i);
            if(usedCapacity>capacity)
                return false;
        }
        return true;
    }
}
