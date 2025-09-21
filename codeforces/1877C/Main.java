// https://codeforces.com/problemset/problem/1877/C
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
            if(k>3)
                System.out.println(0);
            else if (k==1)
                System.out.println(1);
            else if(k==2) 
                System.out.println(m>=n?(long)m/n + n - 1:m);
            else {
                long res = m - n - (long)m/n + 1;
                System.out.println(res<0?0:res);
            } 
        }
    }
}
