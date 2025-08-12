// https://cses.fi/problemset/task/1073/
import java.util.*;
import java.util.Map.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(), res=0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i=0;i<n;i++) {
            int ele = sc.nextInt();
            Entry<Integer, Integer> entry = map.higherEntry(ele);
            if(entry==null)
                res++;
            else {
                if(entry.getValue()==1)
                    map.remove(entry.getKey());
                else
                    map.put(entry.getKey(), entry.getValue()-1);
            }
            map.put(ele, map.getOrDefault(ele, 0)+1);
        }
        System.out.println(res);
    }
}
