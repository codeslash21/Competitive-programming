// https://codeforces.com/problemset/problem/1582/B
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt();
            int cntZero=0, cntOne=0;
            long res=0;
            for(int i=0;i<n;i++) {
                int ele = sc.nextInt();
                if(ele==0)
                    cntZero++;
                else if(ele==1)
                    cntOne++;
            }
            res=(long)Math.pow(2, cntZero)*cntOne;
            System.out.println(res);
        }
    }
}
