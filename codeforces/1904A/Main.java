// https://codeforces.com/problemset/problem/1904/A
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int[] k = new int[2], q = new int[2];
            Set<String> set = new HashSet<>();
            int a = sc.nextInt(), b = sc.nextInt(), res = 0;
            int[][] dirs = {{a,b},{a,-b},{-a,b},{-a,-b},{b,a},{-b,a},{b,-a},{-b,-a}};
            k[0]=sc.nextInt(); k[1]=sc.nextInt();
            q[0]=sc.nextInt(); q[1]=sc.nextInt();
            for(int[] dir:dirs)
                set.add((k[0]+dir[0]) + " " + (k[1]+dir[1]));
            for(int[] dir:dirs) {
                if(set.contains((q[0]+dir[0]) + " " + (q[1]+dir[1])))
                    res++;
            }
            System.out.println(a==b?res/2:res);
        }
    }
}
