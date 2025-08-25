// https://codeforces.com/problemset/problem/1766/A
import java.util.*;

public class A_Extremely_Round {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt();
            int cnt=0, div=1000000;
            while(div>1) {
                int res=(int)n/div;
                if(res>0)
                    n=div-1;
                cnt+=res;
                div/=10;
            }
            System.out.println(cnt+n);
        }
    }
}
