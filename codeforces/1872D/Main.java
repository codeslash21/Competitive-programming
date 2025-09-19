// https://codeforces.com/problemset/problem/1872/D
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            long n = sc.nextLong(), x = sc.nextLong(), y = sc.nextLong(), a = x, b = y;
            long res = 0;
            while(b!=0) {
                long temp = a%b;
                a = b;
                b = temp;
            }
            long xn = (long)n/x, yn = (long)n/y, cn = (long)(n*a)/(x*y);
            xn-=cn; yn-=cn;
            res+=((n*(n+1))/2 - ((n-xn)*(n-xn+1))/2 - (yn*(yn+1))/2);
            System.out.println(res);
        }
    }
}
