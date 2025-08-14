// https://codeforces.com/contest/903/problem/C
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), res=0;
        int[] arr = new int[n];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i=0;i<n;i++)
          arr[i] = sc.nextInt();
        Arrays.sort(arr);
        for(int i=n-1;i>=0;i--) {
          int ele = arr[i];
          Integer key = map.higherKey(ele);
          if(key!=null) {
            if(map.get(key)==1)
              map.remove(key);
            else 
              map.put(key, map.getOrDefault(key, 0)-1);
          }
          map.put(ele, map.getOrDefault(ele, 0)+1);
        }
        for(Integer value:map.values())
          res+=value;
        System.out.println(res);
    }
}
