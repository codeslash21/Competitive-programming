// https://codeforces.com/problemset/problem/1675/B
import java.util.*;

public class B_Make_It_Increasing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        l: while(t-->0) {
            int n = sc.nextInt(), cnt=0;
            int[] arr = new int[n];
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
            if(arr[n-1]==0) {
                System.out.println(n==1?0:-1);
                continue l;
            }
            for(int i=n-2;i>=0;i--) {
                int ele = arr[i], prev = arr[i+1];
                while(ele>=prev) {
                    ele/=2;
                    cnt++;
                }
                if(ele==0 && i>0) {
                    System.out.println(-1);
                    continue l;
                }
                arr[i] = ele;
            }
            System.out.println(cnt);
        }
    }
}
