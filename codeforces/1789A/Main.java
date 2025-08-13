// https://codeforces.com/problemset/problem/1789/A
import java.util.*;

public class Main {
    public static int gcd(int a, int b) {
        if(b==0)
            return a;
        return gcd(b, a%b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        l: while(t-->0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
            Arrays.sort(arr);
            for(int i=0;i<n-1;i++)
                for(int j=i+1;j<n;j++) {
                    if(gcd(arr[j], arr[i])<3) {
                        System.out.println("YES");
                        continue l;
                    }
                }
            System.out.println("NO");
        }
    }
}
