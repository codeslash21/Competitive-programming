// https://codeforces.com/problemset/problem/1814/A
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            long n=sc.nextLong(), k=sc.nextLong();
            String res = n%2==0?"YES":k%2==0?"NO":"YES";
            System.out.println(res);
        }
    }
}
