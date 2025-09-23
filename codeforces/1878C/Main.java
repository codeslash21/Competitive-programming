// https://codeforces.com/problemset/problem/1878/C
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            long n = sc.nextLong(), k = sc.nextLong(), x = sc.nextLong();
            long minSum = (k*(k+1))/2, maxSum = (n*(n+1)-(n-k)*(n-k+1))/2;
            System.out.println((x>=minSum && x<=maxSum)?"YES":"NO");
        }
    }
}
