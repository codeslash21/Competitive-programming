// https://cses.fi/problemset/task/1091/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m=sc.nextInt(), left=0, right=n-1, rem=n, count=0;
        TreeMap<Integer, Integer> h = new TreeMap<>(Collections.reverseOrder());
        for(int i=0;i<n;i++) {
            int ele = sc.nextInt();
            h.put(ele, h.getOrDefault(ele, 0)+1);
        }
        for(int i=0;i<m;i++) {
            int ele = sc.nextInt();
//          ceilingKey returns smallest value >= ele if keys are in ascending order or
//          greatest element <= ele if keys are in descending order
            Integer key = h.ceilingKey(ele);
            if(key==null)
                System.out.println(-1);
            else {
                System.out.println(key);
                if(h.get(key)==1)
                    h.remove(key);
                else
                    h.put(key, h.get(key)-1);
            }
        }
    }
}
