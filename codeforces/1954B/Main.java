// https://codeforces.com/problemset/problem/1954/B
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt(), res = Integer.MAX_VALUE, cnt = 0;
            int[] arr = new int[n];
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
            for(int i=0;i<n;i++) {
                if(arr[i]==arr[0]) 
                    cnt++;
                else {
                    res = Math.min(res, cnt);
                    cnt=0;
                }
            }
            res = Math.min(res, cnt);
            System.out.println(res==n?-1:res);    
        }
    }
}
