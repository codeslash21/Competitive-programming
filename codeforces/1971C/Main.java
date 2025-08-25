// https://codeforces.com/problemset/problem/1971/C
import java.util.*;

public class C_Clock_and_Strings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            if((c>=Math.min(a,b) && c<=Math.max(a,b))^(d>=Math.min(a,b) && d<=Math.max(a,b)))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
