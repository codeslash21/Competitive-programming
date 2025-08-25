// https://codeforces.com/problemset/problem/630/A
import java.util.*;

public class A_Again_Twenty_Five {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int res = 5;
        for(int i=1;i<n;i++) {
            res*=5;
            res%=100;
        }
        System.out.println(res);
    }
}
