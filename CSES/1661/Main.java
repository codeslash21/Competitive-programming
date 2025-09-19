// https://cses.fi/problemset/task/1661
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), x = sc.nextInt();
        long sum=0, res=0;
        int[] arr = new int[n];
        Map<Long, Integer> map = new HashMap<>();
        map.put((long)0, 1);
        for(int i=0;i<n;i++) {
            int ele = sc.nextInt();
            sum+=(long)ele;
            if(map.containsKey(sum-x))
                res+=(long)map.get(sum-x);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        System.out.println(res);
    }
}
