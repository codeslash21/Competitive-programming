//https://codeforces.com/contest/2043/problem/A
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int res = 1;
            Long n = sc.nextLong();
            while(n>3) {
                n = n/4;
                res = res*2;
            }
            System.out.println(res);
        }
    }
}
