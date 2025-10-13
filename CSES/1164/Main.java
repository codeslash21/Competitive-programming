// https://cses.fi/problemset/task/1164
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(), room=1;
        List<List<Integer>> stays=new ArrayList<>();
        PriorityQueue<List<Integer>> minHeap=new PriorityQueue<>((a,b)->a.get(0)-b.get(0));
        int[] rooms=new int[n];
        for(int i=0;i<n;i++)
            stays.add(List.of(sc.nextInt(), sc.nextInt(), i));
        Collections.sort(stays, (a,b)->a.get(0)-b.get(0));
        for(List<Integer> stay:stays) {
            List<Integer> top=minHeap.peek();
            if(minHeap.isEmpty() || top.get(0)>=stay.get(0)) {
                minHeap.add(List.of(stay.get(1), room));
                rooms[stay.get(2)]=room++;
            } else {
                minHeap.poll();
                minHeap.add(List.of(stay.get(1), top.get(1)));
                rooms[stay.get(2)]=top.get(1);
            }
        }
        System.out.println(room-1);
        for(int roomNo:rooms)
            System.out.print(roomNo+" ");
    }
}
