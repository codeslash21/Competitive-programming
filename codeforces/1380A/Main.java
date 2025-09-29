// https://codeforces.com/problemset/problem/1380/A
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        l: while(t-->0) {
            int n=sc.nextInt();
            int[] arr = new int[n+1];
            for(int i=1;i<=n;i++)
                arr[i] = sc.nextInt();
            for(int j=2;j<n;j++) {
                if(arr[j-1]<arr[j] && arr[j+1]<arr[j]) {
                    System.out.println("YES\n"+(j-1)+" "+j+" "+(j+1));
                    continue l;
                }
            }
            System.out.println("NO");
        }
    }
}
