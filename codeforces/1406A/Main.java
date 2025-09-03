// https://codeforces.com/problemset/problem/1406/A
import java.util.*;

public class A_Subset_Mex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt(), a=101, b=101;
            int[] arr = new int[101];
            for(int i=0;i<n;i++) {
                int ele = sc.nextInt();
                arr[ele]++;
            }
            for(int i=0;i<=n;i++) {
                if(arr[i]==1)
                    b = Math.min(b, i);
                else if(arr[i]==0) {
                    a = Math.min(a, i);
                    b = Math.min(b,i);
                    break;
                }
            }
            System.out.println(a+b);
        }
    }
}
