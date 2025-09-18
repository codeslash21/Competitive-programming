// https://cses.fi/problemset/task/1164
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), room=1;
        List<List<Integer>> lists = new ArrayList<>();
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>((a,b)->a.get(0)-b.get(0));
        int[] res = new int[n];
        for(int i=0;i<n;i++) {
            int start = sc.nextInt(), end = sc.nextInt();
            lists.add(Arrays.asList(start, end, i));
        }
        Collections.sort(lists, (a,b)-> {
            if(a.get(0)==b.get(0))
                return a.get(1)-b.get(1);
            return a.get(0)-b.get(0);
        });
        for(int i=0;i<n;i++) {
            List<Integer> curr = lists.get(i);
            List<Integer> top = minHeap.peek();
            if(minHeap.isEmpty() || top.get(0)>=curr.get(0)) {
                minHeap.add(Arrays.asList(curr.get(1), room));
                res[curr.get(2)]=room;
                room++;
            } else {
                minHeap.poll();
                minHeap.add(Arrays.asList(curr.get(1), top.get(1)));
                res[curr.get(2)]=top.get(1);
            }
        }
        System.out.println(room-1);
        for(int i=0;i<n;i++)
            System.out.print(res[i] + " ");
    }
}
