// https://codeforces.com/problemset/problem/1989/A
import java.util.*;

public class A_Catch_the_Coin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int x = sc.nextInt(), y=sc.nextInt();
            if(y>=-1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
