// https://cses.fi/problemset/task/1163/
import java.util.*;

public class Main {
    public static class Pair <K extends Comparable<K>, V extends Comparable<V>> implements Comparable<Pair<K,V>> {
        K first;
        V second;
        public Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }
        @Override
        public int compareTo(Pair<K,V> other) {
            int diff = this.first.compareTo(other.first);
            if(diff==0)
                return this.second.compareTo(other.second);
            return diff;
        }
    }
    public  static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int x=sc.nextInt(), n=sc.nextInt();
        TreeSet<Pair<Integer, Integer>> ranges = new TreeSet<>();
        TreeMap<Integer, Integer> rangeLengths = new TreeMap<>();
        ranges.add(new Pair(0, x));
        rangeLengths.put(x, 1);
        for(int i=0;i<n;i++) {
            int pos = sc.nextInt();
            Pair<Integer, Integer> range = ranges.floor(new Pair(pos, Integer.MAX_VALUE));
            ranges.remove(range);
            int left=range.first, right=range.second, rangeLength=right-left;
            ranges.add(new Pair(left, pos));
            ranges.add(new Pair(pos, right));
            if(rangeLengths.get(rangeLength)==1)
                rangeLengths.remove(rangeLength);
            else
                rangeLengths.put(rangeLength, rangeLengths.getOrDefault(rangeLength, 0)-1);
            rangeLengths.put(pos-left, rangeLengths.getOrDefault(pos-left, 0)+1);
            rangeLengths.put(right-pos, rangeLengths.getOrDefault(right-pos, 0)+1);
            System.out.println(rangeLengths.lastKey());
        }
    }
}
