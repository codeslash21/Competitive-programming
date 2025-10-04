// https://codeforces.com/problemset/problem/1790/D
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n=sc.nextInt();
            int[] arr = new int[n];
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
            Arrays.sort(arr);
            for(int i=n-1;i>=0;i--) {
                int ele = arr[i];
                Integer key = map.ceilingKey(ele+1);
                if(key==null || (key-ele)>1)
                    map.put(ele, map.getOrDefault(ele, 0)+1);
                else {
                    if(map.get(key)==1)
                        map.remove(key);
                    else
                        map.put(key, map.get(key)-1);
                    map.put(ele, map.getOrDefault(ele, 0)+1);
                }
            }
            System.out.println(map.values().stream().mapToInt(Integer::intValue).sum());
        }
    }
}
