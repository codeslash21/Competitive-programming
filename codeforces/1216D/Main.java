// https://codeforces.com/problemset/problem/1216/D
import java.util.*;

public class D_Swords {
    public static int gcd(int a, int b) {
        return b==0?a:gcd(b, a%b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), gcd = 0, max=0;
        long res=0;
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
            max = Math.max(max, arr[i]);
        }
        for(int a : arr)
            gcd = gcd(gcd, max-a);
        for(int a : arr)
            res+=(max-a)/gcd;
        System.out.println(res + " " + gcd);
    }
}
