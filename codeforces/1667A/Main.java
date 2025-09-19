// https://codeforces.com/problemset/problem/1667/A
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long ans = Long.MAX_VALUE;
        long[] arr = new long[n+1];
        for(int i=1;i<=n;i++) 
            arr[i] = sc.nextLong();
        for(int i=1;i<=n;i++) {
            long curr=0, steps=0;
            for(int j=i+1;j<=n;j++) {
                long step = curr/arr[j]+1;
                steps+=step;
                curr=arr[j]*step;
            }
            curr=0;
            for(int j=i-1;j>0;j--) {
                long step = curr/arr[j]-1;
                steps+=Math.abs(step);
                curr=arr[j]*step;
            }
            ans=Math.min(ans, steps);
        }
        System.out.println(ans);
        
    }
}
