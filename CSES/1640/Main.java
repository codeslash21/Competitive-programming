// https://cses.fi/problemset/task/1640/
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), x=sc.nextInt(), count=0, currEnd=0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=1;i<=n;i++) {
            int ele=sc.nextInt();
            if(map.containsKey(x-ele)) {
                System.out.println(map.get(x-ele) + " " + i);
                return;
            }
            map.put(ele, i);
        }
        System.out.println("IMPOSSIBLE");
    }
}
