// https://leetcode.com/problems/my-calendar-i/description/
// t.c.=O(n), s.c.=O(n)
class MyCalendar {
    List<int[]> bookings;
    public MyCalendar() {
        bookings=new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        int left=0, right=bookings.size();
        while(left<right) {
            int mid=left+(right-left)/2;
            if(bookings.get(mid)[0]<startTime)
                left=mid+1;
            else
                right=mid;
        }
        // check left neightbour
        if(left>0 && bookings.get(left-1)[1]>startTime)   return false;
        // check right neighbour
        if(left<bookings.size() && bookings.get(left)[0]<endTime)   return false;
        bookings.add(left, new int[]{startTime, endTime});
        return true;
    }
}

// using TreeMap
// t.c.=O(logn), s.c.=O(n)
class MyCalendar {
    private TreeMap<Integer, Integer> bookings;
    public MyCalendar() {
        bookings=new TreeMap<>();
    }
    
    public boolean book(int startTime, int endTime) {
        // check previous entry if exists
        Map.Entry<Integer, Integer> floor=bookings.floorEntry(startTime);
        if(floor!=null && floor.getValue()>startTime)   return false;
        // check next entry if exists
        Map.Entry<Integer, Integer> ceiling=bookings.ceilingEntry(startTime);
        if(ceiling!=null && ceiling.getKey()<endTime)   return false;
        bookings.put(startTime, endTime);
        return true;
    }
}
