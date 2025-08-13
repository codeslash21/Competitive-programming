// https://codeforces.com/contest/2131/problem/C
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n=sc.nextInt(), k=sc.nextInt();
            boolean flag = true;
            Map<Integer, Integer> map = new HashMap<>();
            for(int i=0;i<n;i++) {
                int ele = sc.nextInt();
                map.put(ele%k, map.getOrDefault(ele%k, 0)+1);
            }
            for(int i=0;i<n;i++) {
                int ele=sc.nextInt(), mod=ele%k, modComp=k-mod;
                if(map.containsKey(mod))
                    if(map.get(mod)==1)
                        map.remove(mod);
                    else
                        map.put(mod, map.getOrDefault(mod, 0)-1);
                else if(map.containsKey(modComp))
                    if(map.get(modComp)==1)
                        map.remove(modComp);
                    else
                        map.put(modComp, map.getOrDefault(modComp, 0)-1);
                else {
                    flag=false;
                }
            }
            System.out.println(flag?"YES":"NO");
        }
    }
}
