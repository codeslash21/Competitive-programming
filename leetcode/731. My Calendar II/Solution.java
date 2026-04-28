// https://leetcode.com/problems/my-calendar-ii/description/
// t.c.=O(n^2), s.c.=O(n)
class MyCalendarTwo {
    List<int[]> bookings, overlappedIntervals;
    public MyCalendarTwo() {
        bookings=new ArrayList<>();
        overlappedIntervals=new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        // check for triple booking
        for(int[] interval:overlappedIntervals)
            if(Math.max(interval[0], startTime)<Math.min(interval[1], endTime))
                return false;
        // check for second booking
        for(int[] booking:bookings) 
            if(Math.max(booking[0], startTime)<Math.min(booking[1], endTime))
                overlappedIntervals.add(new int[] {Math.max(booking[0], startTime), Math.min(booking[1], endTime)});
        // add the new booking
        bookings.add(new int[] {startTime, endTime});
        return true;
    }
}

// using TreeMap
// t.c.=O(nlogn), s.c.=O(n)
class MyCalendarTwo {
    TreeMap<Integer, Integer> timeline;
    public MyCalendarTwo() {
        timeline=new TreeMap<>();
    }
    
    public boolean book(int startTime, int endTime) {
        timeline.merge(startTime, 1, Integer::sum);
        timeline.merge(endTime, -1, Integer::sum);
        // sweep through the timeline
        int count=0;
        for(int delta:timeline.values()) {
            count+=delta;
            if(count>2) {
                timeline.merge(startTime, -1, Integer::sum);
                timeline.merge(endTime, 1, Integer::sum);
                if(timeline.get(startTime)==0)  timeline.remove(startTime);
                if(timeline.get(endTime)==0)    timeline.remove(endTime);
                return false;
            }
        }
        return true;
    }
}
