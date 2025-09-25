// https://codeforces.com/problemset/problem/1624/B
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int a=sc.nextInt(), b=sc.nextInt(), c=sc.nextInt();
            int diff31=c-a, diff21=b-a, diff32=c-b;
            int mid=a+diff31/2, last=b+diff21, first=b-diff32;
            if((mid>=b && mid%b==0 && diff31%2==0) || (last>=c && last%c==0) || (first>=a && first%a==0))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
