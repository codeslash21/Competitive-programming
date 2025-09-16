// https://cses.fi/problemset/task/3420
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), res=0, lastIdx=0;
        int[] arr = new int[n];
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();
        for(int i=0;i<n;i++) {
            int ele = arr[i];
            if(set.contains(ele) &&  map.get(ele)>=lastIdx)
                lastIdx = map.get(ele)+1;
            res += (i-lastIdx+1);
            set.add(ele);
            map.put(ele, i);
        }
        System.out.println(res);
    }
}
