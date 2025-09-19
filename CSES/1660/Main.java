// https://cses.fi/problemset/task/1660
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), x = sc.nextInt(), res=0;
        long sum=0;
        int[] arr = new int[n];
        Set<Long> set = new HashSet<>();
        set.add((long)0);
        for(int i=0;i<n;i++) {
            int ele = sc.nextInt();
            sum+=(long)ele;
            if(set.contains(sum-x))
                res++;
            set.add(sum);
        }
        System.out.println(res);
    }
}
