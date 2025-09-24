// https://codeforces.com/problemset/problem/1726/A
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
            int ans = arr[n-1]-arr[0], max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;
            for(int i=0;i<n;i++)
                ans = Math.max(ans, arr[i]-arr[(i+1)%n]);
            for(int i=1;i<n;i++)
                max=Math.max(max, arr[i]);
            ans = Math.max(ans, max-arr[0]);
            for(int i=0;i<n-1;i++)
                min=Math.min(min, arr[i]);
            ans = Math.max(ans, arr[n-1]-min);
            System.out.println(n==1?0:ans);
        }
    }
}
