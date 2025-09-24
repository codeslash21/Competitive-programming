// https://codeforces.com/problemset/problem/1807/D
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n=sc.nextInt(), q=sc.nextInt();
            long[] arr = new long[n+1];
            for(int i=1;i<=n;i++)
                arr[i] = arr[i-1]+sc.nextLong();
            while(q-->0) {
                int l=sc.nextInt(), r=sc.nextInt(), k=sc.nextInt();
                long sum = arr[l-1]+(arr[n]-arr[r])+(long)(r-l+1)*k;
                System.out.println(sum%2>0?"YES":"NO");
            }
        }
    }
}
