// https://codeforces.com/problemset/problem/1881/A
import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        l: while(t-->0) {
            int n = sc.nextInt(), m = sc.nextInt();
            String x = sc.next(), s = sc.next();
            StringBuilder sb = new StringBuilder();
            sb.append(x);
            int max = 6;
            while(max-->0) {
                if(sb.toString().contains(s)) {
                    System.out.println(5 - max);
                    continue l;
                }
                sb.append(x);
                x = sb.toString();
            }
            System.out.println(-1);
        }
    }
}
