// https://codeforces.com/problemset/problem/1696/B
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt(), l=0, r=0, cnt=0;
            int[] arr = new int[n];
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
            for(r=0;r<n;r++) 
                  if(arr[r]==0) {
                      int diff=r-l;
                      if(diff>0)
                          cnt++;
                      l=r+1;
                  }
            cnt+=(r>l?1:0);
            System.out.println(cnt<3?cnt:2);
        }
    }
}
