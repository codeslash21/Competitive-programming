// https://codeforces.com/problemset/problem/1705/B
import java.util.*;

public class B_Mark_the_Dust_Sweeper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            long n = sc.nextInt(), res=0;
            boolean firstNonZeroFound = false;
            for(long i=0;i<n-1;i++) {
                long ele = sc.nextInt();
                if(ele!=0)
                    firstNonZeroFound = true;
                res+=(firstNonZeroFound?(ele==0?1:ele):0);
            }
            sc.nextInt();
            System.out.println(res);
        }
    }
}
