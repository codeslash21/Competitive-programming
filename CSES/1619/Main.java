// https://cses.fi/problemset/task/1619/

import java.util.*;

public class Main {
    static class Pair {
        int time;
        boolean isStart;
        Pair(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), active=0, maxOverlap=0, time=0;
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b) -> {
            if(a.time!=b.time)
                return Integer.compare(a.time, b.time);
            else
                return Boolean.compare(b.isStart, a.isStart);
        });
        for(int i=0;i<n;i++) {
            time = sc.nextInt();
            minHeap.add(new Pair(time, true));
            time = sc.nextInt();
            minHeap.add(new Pair(time, false));
        }
        while(!minHeap.isEmpty()) {
            Pair pair = minHeap.poll();
            active += pair.isStart?1:-1;
            maxOverlap=Math.max(maxOverlap, active);
        }
        System.out.println(maxOverlap);
    }
}
