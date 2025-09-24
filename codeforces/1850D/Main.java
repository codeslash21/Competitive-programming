// https://codeforces.com/problemset/problem/1850/D
import java.util.*;

public class D_Balanced_Round {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n=sc.nextInt(), k=sc.nextInt(), cnt=1, res=0;
            int[] arr=new int[n];
            for(int i=0;i<n;i++)
                arr[i]=sc.nextInt();
            Arrays.sort(arr);
            for(int i=1;i<n;i++) {
                if(arr[i]-arr[i-1]<=k)
                    cnt++;
                else {
                    res=Math.max(res, cnt);
                    cnt=1;
                }
            }
            res=Math.max(res, cnt);
            System.out.println(n-res);
        }
    }
}
