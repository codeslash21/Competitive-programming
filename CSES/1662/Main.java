// https://cses.fi/problemset/task/1662
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long sum = 0, res = 0;
        Map<Long, Integer> map = new HashMap<>();
        map.put((long)0, 1);
        for(int i=0;i<n;i++) {
            long ele = sc.nextLong();
            sum+=ele;
            long mod = ((sum%n)+n)%n;
            res+=map.getOrDefault(mod, 0);
            map.put(mod, map.getOrDefault(mod, 0)+1);
        }
        System.out.println(res);
    }
}
