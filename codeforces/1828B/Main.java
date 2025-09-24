// https://codeforces.com/problemset/problem/1828/B
import java.util.*;

public class Main {
    public static int gcd(int a, int b) {
        return b==0?a:gcd(b, a%b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n=sc.nextInt(), gcd;
            int[] arr=new int[n+1];
            for(int i=1;i<=n;i++) 
                arr[i]=Math.abs(sc.nextInt()-i);
            gcd=arr[1];
            for(int i=2;i<=n;i++)
                gcd = gcd(gcd, arr[i]);
            System.out.println(gcd);
        }
    }
}
