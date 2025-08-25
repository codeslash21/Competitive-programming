// https://codeforces.com/problemset/problem/1426/B
import java.util.*;

public class B_Symmetric_Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt(), m = sc.nextInt();
            boolean sym = false;
            for(int i=0;i<n;i++) {
                int a = sc.nextInt(), b=sc.nextInt();
                int c=sc.nextInt(), d=sc.nextInt();
                if(c==b)
                    sym=true;
            }
            System.out.println(m%2==1?"NO":sym?"YES":"NO");
        }
    }
}
