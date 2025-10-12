// https://cses.fi/problemset/task/1163/
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x=sc.nextInt(), n=sc.nextInt();
        TreeMap<Integer, Integer> ranges=new TreeMap<>(), rangeLengths=new TreeMap<>();
        ranges.put(0, x);
        rangeLengths.put(x, 1);
        for(int i=0;i<n;i++) {
            int pos=sc.nextInt();
            int left=ranges.floorKey(pos), right=ranges.get(left), length=right-left;
            ranges.put(left, pos);
            ranges.put(pos, right);
            if(rangeLengths.get(length)==1)
                rangeLengths.remove(length);
            else
                rangeLengths.put(length, rangeLengths.getOrDefault(length, 0)-1);
            rangeLengths.put(right-pos, rangeLengths.getOrDefault(right-pos, 0)+1);
            rangeLengths.put(pos-left, rangeLengths.getOrDefault(pos-left, 0)+1);
            System.out.println(rangeLengths.lastKey());
        }
    }
}
