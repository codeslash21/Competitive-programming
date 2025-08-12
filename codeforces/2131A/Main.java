// https://codeforces.com/contest/2131/problem/A
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n=sc.nextInt(), res=0;
            int[] a = new int[n], b = new int[n];
            for(int i=0;i<n;i++)
                a[i] = sc.nextInt();
            for(int i=0;i<n;i++)
                b[i] = sc.nextInt();
            for(int i=0;i<n;i++)
                if(a[i]>b[i])
                    res+=(a[i]-b[i]);
            System.out.println(res+1);
        }
    }
}
