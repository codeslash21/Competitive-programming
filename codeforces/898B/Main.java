// https://codeforces.com/problemset/problem/898/B
import java.util.*;

public class B_Proper_Nutrition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt();
        int t = n/a;
        for(int i=0;i<=t;i++) {
            int rem = n - (i*a);
            if(rem%b==0) {
                System.out.println("YES");
                System.out.println(i + " " + (rem/b));
                return;
            }
        }
        System.out.println("NO");
    }
}
