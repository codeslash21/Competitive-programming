// https://cses.fi/problemset/task/1141/
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int start=0, end=0, res=0;
        Map<Integer, Integer> map = new HashMap<>();
        for(end=0;end<n;end++) {
            int ele=sc.nextInt();
            if(map.containsKey(ele) && map.get(ele)>=start) {
                res = Math.max(res, end - start);
                start = map.get(ele) + 1;
            }
            map.put(ele, end);

        }
        res = Math.max(res, end - start);
        System.out.println(res);
    }
}
